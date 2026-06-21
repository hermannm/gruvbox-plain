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
import kotlin.text.isUpperCase

private val JS_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.KEYWORD,
            symbols = arrayOf("..."),
        ),
        HighlightingGroup(
            Highlighting.VALUE,
            symbols = arrayOf("this"),
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

  val isType = element.isType()
  if (isType) {
    return Highlighting.TYPE
  }

  val nextElement = element.nextLeaf()
  val prevElement = element.prevLeaf()
  if (nextElement != null) {
    /**
     * Functions calls are sometimes not highlighted properly (e.g. when a function is returned from
     * another function), so we do special-case handling of all function-call-esque syntax here
     * (including '<' for generic functions).
     */
    if (nextElement.textMatches("(") || nextElement.textMatches("<")) {
      return if (prevElement?.textMatches("@") == true) {
        // We want to use type highlighting for decorators
        Highlighting.TYPE
      } else {
        // Other function calls should use normal function highlighting
        Highlighting.FUNCTION
      }
    }

    /**
     * If next element is a dot, then this might be a namespace identifier in front of a type, which
     * we also want to highlight as a type
     */
    if (
        nextElement.textMatches(".") &&
            isNamespaceComponentPrecedingType(nextDotElement = nextElement)
    ) {
      return Highlighting.TYPE
    }
  }

  /**
   * IntelliJ highlights getters as function calls by default, but we want to highlight them as
   * properties. So if the element is preceded by a dot, and the element text is not a type
   * identifier, then we highlight it as a variable.
   *
   * If the element _was_ a type, then we give the preceding identifier type highlighting, as that's
   * the highlighting we want for namespaces.
   */
  if (prevElement != null && prevElement.textMatches(".")) {
    if (!isType) {
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
  val text = this.text
  return text.firstOrNull()?.isUpperCase() == true
  /** Don't count constants on SCREAMING_SNAKE_CASE as types. */
  && !text.isScreamingSnakeCase()
}

/** Returns true if the string follows SCREAMING_SNAKE_CASE. */
private fun String.isScreamingSnakeCase(): Boolean {
  return this.all { it.isUpperCase() || it == '_' }
}

/**
 * @param nextDotElement Assumes that this element is the next leaf sibling of the element we're
 *   currently investigating, and that we have already checked that its text matches "."
 */
private fun isNamespaceComponentPrecedingType(
    nextDotElement: PsiElement,
): Boolean {
  var nextDotElement: PsiElement = nextDotElement
  while (true) {
    val nextNamespaceComponent = nextDotElement.nextLeaf() ?: return false

    if (nextNamespaceComponent.name() != "JS:IDENTIFIER") {
      return false
    }

    /**
     * If the namespace sequence ends in a type, then we assume that the preceding identifiers were
     * part of a namespace.
     *
     * This only works for types, not functions, as we can't identify for a function if the
     * preceding identifiers were variables or namespace components.
     */
    if (nextNamespaceComponent.isType()) {
      return true
    }

    nextDotElement = nextNamespaceComponent.nextLeaf() ?: return false
    if (!nextDotElement.textMatches(".")) {
      return false
    }
  }
}

private fun PsiElement.elementBeforePreviousSpace(): PsiElement? {
  var foundPreviousSpace = false
  val element =
      this.prevLeaf {
        if (it.textMatches(";") || it.textMatches(")") || it.textMatches("(")) {
          return@prevLeaf true
        }

        if (it.textMatches(" ")) {
          foundPreviousSpace = true
          return@prevLeaf false
        }

        return@prevLeaf foundPreviousSpace
      }
  return if (foundPreviousSpace) element else null
}
