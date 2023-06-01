package dev.hermannm.gruvboxplain.java

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.isGenericBracket
import dev.hermannm.gruvboxplain.keywordHighlighting
import dev.hermannm.gruvboxplain.punctuationHighlighting
import dev.hermannm.gruvboxplain.typeHighlighting
import dev.hermannm.gruvboxplain.valueHighlighting

class JavaAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "->" -> keywordHighlighting
            "this", "true", "false", "null" -> valueHighlighting
            "char",
            "boolean",
            "int",
            "float",
            "double",
            "long",
            "short",
            "byte",
            "void"
            -> typeHighlighting
            "::" -> punctuationHighlighting
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            else -> return
        }

        element.highlight(highlighting, annotationHolder)
    }
}
