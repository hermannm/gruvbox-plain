package dev.hermannm.gruvboxplain.cpp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import dev.hermannm.gruvboxplain.functionHighlighting
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.isGenericBracket
import dev.hermannm.gruvboxplain.punctuationHighlighting
import dev.hermannm.gruvboxplain.typeHighlighting
import dev.hermannm.gruvboxplain.valueHighlighting

class CppAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "this", "true", "false", "nullptr" -> valueHighlighting
            "int",
            "char",
            "bool",
            "float",
            "double",
            "void",
            "long",
            "short",
            "signed",
            "unsigned",
            -> typeHighlighting
            "sizeof" -> functionHighlighting
            ":", "::", "->" -> punctuationHighlighting
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            else -> if (element.isAttribute()) typeHighlighting else return
        }

        element.highlight(highlighting, annotationHolder)
    }
}

fun PsiElement.isAttribute(): Boolean {
    return this.elementType?.toString() == "IDENTIFIER" &&
        this.parent?.javaClass?.simpleName == "OCAttributeImpl"
}
