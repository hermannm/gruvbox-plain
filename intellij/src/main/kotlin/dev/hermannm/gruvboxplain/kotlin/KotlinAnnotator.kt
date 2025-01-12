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

    // Skips the immediate parent of the original element, as the package/import element is always
    // at least 2 levels up.
    var parentElement = this.parent?.parent ?: return false

    while (true) {
        when (parentElement.javaClass.simpleName) {
            "KtPackageDirective", "KtImportDirective" -> return true
        }

        parentElement = parentElement.parent ?: return false
    }
}
