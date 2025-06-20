package dev.hermannm.gruvboxplain.js

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.isGenericBracket
import dev.hermannm.gruvboxplain.punctuationHighlighting

class JsAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            ":" -> if (!element.isTernaryColon()) punctuationHighlighting else return
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            else -> return
        }

        element.highlight(highlighting, annotationHolder)
    }
}

/**
 * We want colons to be highlighted as punctuation when specifying object fields or TypeScript
 * types, but keep keyword highlighting when used in a ternary statement. In a ternary, the colon
 * will be preceded by a space, so we can use that to differentiate the two.
 */
private fun PsiElement.isTernaryColon(): Boolean {
    return this.prevSibling is PsiWhiteSpace
}
