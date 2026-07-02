package dev.hermannm.gruvboxplain.python

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.applyHighlighting
import dev.hermannm.gruvboxplain.hasParent
import dev.hermannm.gruvboxplain.name

private val PYTHON_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.KEYWORD,
            symbols = arrayOf("super"),
        ),
        HighlightingGroup(
            Highlighting.VALUE,
            symbols = arrayOf("True", "False"),
        ),
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf(".", ":", "->", "[", "]"),
        ),
    )

public class PythonAnnotator : BaseAnnotator(PYTHON_HIGHLIGHTING_CONFIG) {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    if (element.textMatches("None")) {
      applyHighlighting(getNoneKeywordHighlighting(element), element, annotationHolder)
      return
    }

    if (element.name() == "Py:IDENTIFIER") {
      val highlighting = getIdentifierHighlighting(element)
      if (highlighting != null) {
        applyHighlighting(highlighting, element, annotationHolder)
        return
      }
    }

    super.annotate(element, annotationHolder)
  }
}

/** Returns null if highlighting wasn't handled. */
private fun getIdentifierHighlighting(
    element: PsiElement,
): Highlighting? {
  /** Type highlighting for identifiers in import declarations. */
  if (
      element.hasParent {
        val parentName = it.name()
        parentName == "Py:FROM_IMPORT_STATEMENT" || parentName == "Py:IMPORT_STATEMENT"
      }
  ) {
    return Highlighting.TYPE
  }

  return null
}

private fun getNoneKeywordHighlighting(element: PsiElement): Highlighting {
  return if (element.hasParent { it.name() == "Py:ANNOTATION" }) {
    Highlighting.TYPE
  } else {
    Highlighting.VALUE
  }
}
