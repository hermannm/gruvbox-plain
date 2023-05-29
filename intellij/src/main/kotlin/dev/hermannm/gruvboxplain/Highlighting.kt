package dev.hermannm.gruvboxplain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace

val keywordHighlighting = TextAttributesKey.createTextAttributesKey(
    "GRUVBOX_PLAIN_KEYWORD",
    DefaultLanguageHighlighterColors.KEYWORD,
)

val typeHighlighting = TextAttributesKey.createTextAttributesKey(
    "GRUVBOX_PLAIN_TYPE",
    DefaultLanguageHighlighterColors.CLASS_NAME,
)

val valueHighlighting = TextAttributesKey.createTextAttributesKey(
    "GRUVBOX_PLAIN_VALUE",
    DefaultLanguageHighlighterColors.STRING,
)

val punctuationHighlighting = TextAttributesKey.createTextAttributesKey(
    "GRUVBOX_PLAIN_PUNCTUATION",
    DefaultLanguageHighlighterColors.BRACES,
)

fun PsiElement.highlight(highlighting: TextAttributesKey, annotationHolder: AnnotationHolder) {
    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        .range(this)
        .textAttributes(highlighting)
        .create()
}

fun PsiElement.isGenericBracket(): Boolean {
    return this.prevSibling !is PsiWhiteSpace
}
