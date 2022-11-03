package dev.hermannm.gruvbox_plain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.LanguageConfig
import dev.hermannm.gruvbox_plain.findCustomHighlighting
import dev.hermannm.gruvbox_plain.highlightElement

internal val kotlinLanguageConfig = LanguageConfig(
    name = "Kotlin",
    constantKeywords = arrayOf("this", "true", "false", "null"),
    primitiveKeywords = arrayOf(),
)

class KotlinAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = findCustomHighlighting(element, kotlinLanguageConfig) ?: return
        highlightElement(highlighting, element, annotationHolder)
    }
}
