package dev.hermannm.gruvboxplain.js

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.findParentInFile
import com.intellij.psi.util.nextLeaf
import com.intellij.psi.util.prevLeaf
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.applyHighlighting
import dev.hermannm.gruvboxplain.name

private val JS_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.KEYWORD,
            symbols = arrayOf("..."),
        ),
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf(":"),
            // We want colons to be highlighted as punctuation when specifying object fields
            // or TypeScript types, but keep keyword highlighting when used in a ternary
            // statement. In a ternary, the colon will be preceded by a space, so we can use
            // that to differentiate the two.
            applyIf = { element -> element.prevSibling?.textMatches(" ") == false },
        ),
        HighlightingGroup.GENERIC_BRACKETS,
    )

public class JsAnnotator : BaseAnnotator(JS_HIGHLIGHTING_CONFIG) {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    if (element.name() == "JS:IDENTIFIER") {
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
  /**
   * Constructors are marked as identifiers in IntelliJ, but we want to keep their highlighting
   * as-is.
   */
  if (element.textMatches("constructor")) {
    return null
  }

  val nextElement = element.nextLeaf()
  if (nextElement != null) {
    /**
     * Functions calls are sometimes not highlighted properly (e.g. when a function is returned from
     * another function), so we do special-case handling of all function-call-esque syntax here.
     */
    if (nextElement.textMatches("(")) {
      return if (element.elementBeforePreviousSpace()?.name() == "JS:NEW_KEYWORD") {
        // We want to use type highlighting for class constructors
        Highlighting.TYPE
      } else {
        // Other function calls should use normal function highlighting
        Highlighting.FUNCTION
      }
    }

    /**
     * If next element is a dot, then this might be a namespace identifier in front of a type, which
     * we also want to highlight as a type.
     */
    if (nextElement.textMatches(".")) {
      val secondNextElement = nextElement.nextLeaf()
      if (
          secondNextElement != null &&
              secondNextElement.name() == "JS:IDENTIFIER" &&
              secondNextElement.isType()
      ) {
        return Highlighting.TYPE
      }
    }
  }

  /**
   * IntelliJ highlights getters as function calls by default, but we want to highlight them as
   * properties. So if the element is preceded by a dot, and the element text is not upper-case
   * (i.e. a type), then we highlight it as a variable.
   *
   * If the element _was_ a type, then we give the preceding identifier type highlighting, as that's
   * the highlighting we want for namespaces.
   */
  val prevDotElement = element.prevLeaf()?.takeIf { it.textMatches(".") }
  if (prevDotElement != null) {
    if (!element.isType()) {
      return Highlighting.VARIABLE
    }
  }

  /** Finally, we want to use type highlighting for identifiers in import declarations. */
  val parentImportDeclaration = element.findParentInFile { it.name() == "JS:IMPORT_DECLARATION" }
  if (parentImportDeclaration != null) {
    return Highlighting.TYPE
  }

  return null
}

private fun PsiElement.isType(): Boolean {
  return this.text.firstOrNull()?.isUpperCase() == true
}

private fun PsiElement.elementBeforePreviousSpace(): PsiElement? {
  var foundPreviousSpace = false
  return this.prevLeaf {
    if (it.textMatches(" ")) {
      @Suppress("AssignedValueIsNeverRead") // False positive
      foundPreviousSpace = true
      return@prevLeaf false
    }

    return@prevLeaf foundPreviousSpace
  }
}
