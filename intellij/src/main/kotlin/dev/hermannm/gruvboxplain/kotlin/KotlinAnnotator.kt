package dev.hermannm.gruvboxplain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childLeafs
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.applyHighlighting
import dev.hermannm.gruvboxplain.name

class KotlinAnnotator :
    BaseAnnotator(
        highlightingGroups =
            arrayOf(
                HighlightingGroup(
                    Highlighting.KEYWORD,
                    symbols = arrayOf("?:", "="),
                ),
                HighlightingGroup(
                    Highlighting.VALUE,
                    symbols = arrayOf("this", "true", "false", "null"),
                ),
                HighlightingGroup(
                    Highlighting.TYPE,
                    symbols = arrayOf("@"),
                ),
                HighlightingGroup.GENERIC_BRACKETS,
            ),
    ) {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    when (element.name()) {
      // If element is a package/import declaration, we highlight package path elements
      "PACKAGE_DIRECTIVE",
      "IMPORT_LIST" -> {
        element.highlightChildIdentifiers(Highlighting.TYPE, annotationHolder)
        return
      }
    }

    super.annotate(element, annotationHolder)
  }
}

/** Applies the given highlighting to all child leaf elements of type 'IDENTIFIER'. */
private fun PsiElement.highlightChildIdentifiers(
    highlighting: Highlighting,
    annotationHolder: AnnotationHolder,
) {
  for (childElement in this.childLeafs()) {
    if (childElement.name() == "IDENTIFIER") {
      applyHighlighting(highlighting, childElement, annotationHolder)
    }
  }
}
