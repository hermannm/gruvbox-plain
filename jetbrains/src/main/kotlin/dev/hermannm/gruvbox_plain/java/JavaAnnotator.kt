package dev.hermannm.gruvbox_plain.java

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.LanguageConfig
import dev.hermannm.gruvbox_plain.findCustomHighlighting
import dev.hermannm.gruvbox_plain.highlightElement

internal val javaLanguageConfig = LanguageConfig(
    name = "Java",
    constantKeywords = arrayOf("this", "true", "false", "null"),
    primitiveKeywords = arrayOf("char", "boolean", "int", "float", "double", "long", "short", "byte", "void"),
)

class JavaAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = findCustomHighlighting(element, javaLanguageConfig) ?: return
        highlightElement(highlighting, element, annotationHolder)
    }
}
