package dev.hermannm.gruvboxplain.js

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.nextLeaf
import com.intellij.psi.util.prevLeaf
import dev.hermannm.gruvboxplain.*

class JsAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting: TextAttributesKey =
            if (element.name() == "JS:IDENTIFIER" && element.nextLeaf()?.text == "(") {
                // Some function/constructor calls are not highlighted correctly, e.g. when a
                // function is returned from another function. So we do custom highlighting for
                // function calls here.
                if (element.previousNonWhitespaceLeaf()?.name() == "JS:NEW_KEYWORD") {
                    // We want calls to class constructors to use type highlighting
                    typeHighlighting
                } else {
                    // Other function calls should use normal function highlighting
                    functionHighlighting
                }
            } else {
                when (element.text) {
                    "..." -> keywordHighlighting
                    ":" -> if (!element.isTernaryColon()) punctuationHighlighting else return
                    "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
                    else -> return
                }
            }

        element.highlight(highlighting, annotationHolder)
    }
}

private fun PsiElement.previousNonWhitespaceLeaf(): PsiElement? {
    this.prevLeaf()
    return this.prevLeaf(filter = { it !is PsiWhiteSpace })
}

/**
 * We want colons to be highlighted as punctuation when specifying object fields or TypeScript
 * types, but keep keyword highlighting when used in a ternary statement. In a ternary, the colon
 * will be preceded by a space, so we can use that to differentiate the two.
 */
private fun PsiElement.isTernaryColon(): Boolean {
    return this.prevSibling is PsiWhiteSpace
}
