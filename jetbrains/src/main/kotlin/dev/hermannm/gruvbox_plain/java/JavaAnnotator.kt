package dev.hermannm.gruvbox_plain.java

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.languageConstantHighlighting
import dev.hermannm.gruvbox_plain.primitiveTypeHighlighting
import dev.hermannm.gruvbox_plain.punctuationHighlighting
import dev.hermannm.gruvbox_plain.highlightElement

class JavaAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "this", "true", "false", "null" -> languageConstantHighlighting
            "char", "boolean", "int", "float", "double", "long", "short", "byte", "void" -> primitiveTypeHighlighting
            "<", ">" -> punctuationHighlighting
            else -> return
        }

        highlightElement(highlighting, element, annotationHolder)
    }
}
