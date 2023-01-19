package dev.hermannm.gruvbox_plain.java

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.genericBracketHighlighting
import dev.hermannm.gruvbox_plain.highlightElement
import dev.hermannm.gruvbox_plain.keywordHighlighting
import dev.hermannm.gruvbox_plain.languageConstantHighlighting
import dev.hermannm.gruvbox_plain.primitiveTypeHighlighting
import dev.hermannm.gruvbox_plain.punctuationHighlighting

class JavaAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "->" -> keywordHighlighting
            "this", "true", "false", "null" -> languageConstantHighlighting
            "char", "boolean", "int", "float", "double", "long", "short", "byte", "void" -> primitiveTypeHighlighting
            "::" -> punctuationHighlighting
            "<", ">" -> genericBracketHighlighting(element, "PsiReferenceParameterListImpl") ?: return
            else -> return
        }

        highlightElement(element, highlighting, annotationHolder)
    }
}
