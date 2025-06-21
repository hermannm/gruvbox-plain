package dev.hermannm.gruvboxplain.js

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.nextLeaf
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.applyHighlighting
import dev.hermannm.gruvboxplain.name
import dev.hermannm.gruvboxplain.previousNonSpaceLeaf

class JsAnnotator : BaseAnnotator(CONFIG) {
  companion object {
    private val CONFIG: HighlightingConfig =
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
                applyIf = { element -> !element.prevSibling.textMatches(" ") },
            ),
            HighlightingGroup.GENERIC_BRACKETS,
        )
  }

  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    // Some function/constructor calls are not highlighted correctly, e.g. when a function is
    // returned from another function. So we do custom highlighting for function calls here.
    // We don't want to put this in a `HighlightingGroup`, since we want to choose either Type or
    // Function highlighting depending on whether it's a constructor or not.
    if (element.name() == "JS:IDENTIFIER" && element.nextLeaf()?.textMatches("(") == true) {
      val highlighting =
          if (element.previousNonSpaceLeaf()?.name() == "JS:NEW_KEYWORD") {
            // We want calls to class constructors to use type highlighting
            Highlighting.TYPE
          } else {
            // Other function calls should use normal function highlighting
            Highlighting.FUNCTION
          }

      applyHighlighting(highlighting, element, annotationHolder)
      return
    }

    super.annotate(element, annotationHolder)
  }
}
