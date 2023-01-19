package dev.hermannm.gruvbox_plain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.genericBracketHighlighting
import dev.hermannm.gruvbox_plain.highlightElement
import dev.hermannm.gruvbox_plain.keywordHighlighting
import dev.hermannm.gruvbox_plain.languageConstantHighlighting
import dev.hermannm.gruvbox_plain.primitiveTypeHighlighting

class KotlinAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "?:", "=" -> keywordHighlighting
            "this", "true", "false", "null" -> languageConstantHighlighting
            "<", ">" -> genericBracketHighlighting(element, "KtTypeArgumentList") ?: return
            "." -> return
            else -> if (element.isPackagePathElement()) primitiveTypeHighlighting else return
        }

        highlightElement(element, highlighting, annotationHolder)
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
            (topElementClassName == "KtPackageDirective")
            || (topElementClassName == "KtImportDirective" && bottomElement != middleElement.lastChild)
        ) {
            return true
        }

        bottomElement = middleElement
        middleElement = topElement
    }
}
