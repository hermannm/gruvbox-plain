package dev.hermannm.gruvbox_plain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

val keywordHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
)

val primitiveTypeHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_PRIMITIVE_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME
)

val languageConstantHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_LANGUAGE_CONSTANT", DefaultLanguageHighlighterColors.STRING
)

val punctuationHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_PUNCTUATION", DefaultLanguageHighlighterColors.BRACES
)

fun highlightElement(element: PsiElement, highlighting: TextAttributesKey, annotationHolder: AnnotationHolder) {
    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        .range(element)
        .textAttributes(highlighting)
        .create()
}

fun genericBracketHighlighting(element: PsiElement, typeArgumentListElementName: String): TextAttributesKey? {
    return if (element.parent.javaClass.simpleName == typeArgumentListElementName) {
        punctuationHighlighting
    } else {
        null
    }
}
