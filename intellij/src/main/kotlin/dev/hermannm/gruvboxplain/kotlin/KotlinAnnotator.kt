package dev.hermannm.gruvboxplain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childLeafs
import com.intellij.psi.util.nextLeaf
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.applyHighlighting
import dev.hermannm.gruvboxplain.name

private val KOTLIN_HIGHLIGHTING_CONFIG: HighlightingConfig =
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
    )

public class KotlinAnnotator : BaseAnnotator(KOTLIN_HIGHLIGHTING_CONFIG) {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    when (element.name()) {
      // If element is a package/import declaration, we highlight package path elements
      "PACKAGE_DIRECTIVE",
      "IMPORT_LIST" -> {
        highlightChildIdentifiers(Highlighting.TYPE, element, annotationHolder)
      }
      // Special highlighting for function calls - see `highlightFunctionCall` for more details
      "IDENTIFIER" if isFunctionCall(element) -> {
        highlightFunctionCall(element, annotationHolder)
      }
      else -> {
        super.annotate(element, annotationHolder)
      }
    }
  }
}

/**
 * Function calls in Kotlin may either have an opening parenthesis, or use trailing lambda syntax,
 * in which case the function name will be followed by " {". This matches both syntaxes.
 */
private fun isFunctionCall(element: PsiElement): Boolean {
  val nextElement = element.nextLeaf() ?: return false

  if (nextElement.textMatches("(")) {
    return true
  }

  if (nextElement.textMatches(" ")) {
    val secondNextElement = nextElement.nextLeaf() ?: return false
    return secondNextElement.textMatches("{")
  }

  return false
}

/**
 * Some function/constructor calls are not highlighted correctly, e.g. when a function is returned
 * from another function. So we do custom highlighting for function calls here. We don't want to put
 * this in a `HighlightingGroup`, since we want to choose either Type or Function highlighting
 * depending on whether it's a constructor or not.
 */
private fun highlightFunctionCall(element: PsiElement, annotationHolder: AnnotationHolder) {
  val text = element.text // getText is expensive, so we only want to call it once
  val highlighting =
      when {
        // Use warning highlighting for TODO() calls
        text == "TODO" -> Highlighting.WARNING
        // If call starts with an upper-case letter, then we highlight it as a class constructor
        text.isNotEmpty() && text.first().isUpperCase() -> Highlighting.TYPE
        // Otherwise, use normal function highlighting
        else -> Highlighting.FUNCTION
      }

  applyHighlighting(highlighting, element, annotationHolder)
}

/** Applies the given highlighting to all child leaf elements of type 'IDENTIFIER'. */
private fun highlightChildIdentifiers(
    highlighting: Highlighting,
    element: PsiElement,
    annotationHolder: AnnotationHolder,
) {
  for (childElement in element.childLeafs()) {
    if (childElement.name() == "IDENTIFIER") {
      applyHighlighting(highlighting, childElement, annotationHolder)
    }
  }
}
