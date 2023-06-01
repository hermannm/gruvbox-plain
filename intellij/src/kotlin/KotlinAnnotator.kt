package dev.hermannm.gruvboxplain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.isGenericBracket
import dev.hermannm.gruvboxplain.keywordHighlighting
import dev.hermannm.gruvboxplain.punctuationHighlighting
import dev.hermannm.gruvboxplain.typeHighlighting
import dev.hermannm.gruvboxplain.valueHighlighting

class KotlinAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "?:", "=" -> keywordHighlighting
            "this", "true", "false", "null" -> valueHighlighting
            "@" -> typeHighlighting
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            "." -> return
            else -> if (element.isPackagePathElement()) typeHighlighting else return
        }

        element.highlight(highlighting, annotationHolder)
    }
}

fun PsiElement.isPackagePathElement(): Boolean {
    if (this.children.isNotEmpty()) {
        return false
    }

    var bottomElement = this
    var middleElement = bottomElement.parent ?: return false

    while (true) {
        val topElement = middleElement.parent ?: return false

        val topElementClassName = topElement.javaClass.simpleName

        if (
            (topElementClassName == "KtPackageDirective") ||
            (topElementClassName == "KtImportDirective" && bottomElement != middleElement.lastChild)
        ) {
            return true
        }

        bottomElement = middleElement
        middleElement = topElement
    }
}
