package dev.hermannm.gruvbox_plain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.psi.PsiElement

internal fun highlightElement(
    highlighting: TextAttributesKey,
    element: PsiElement,
    annotationHolder: AnnotationHolder,
) {
    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        .range(element)
        .textAttributes(highlighting)
        .create()
}

internal val genericBrackets = arrayOf("<", ">")

internal val genericBracketHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_JAVA_PRIMITIVE", DefaultLanguageHighlighterColors.BRACES
)

val genericBracketsDescriptor = AttributesDescriptor("Generic brackets", genericBracketHighlighting)
