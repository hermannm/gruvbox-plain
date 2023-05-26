package dev.hermannm.gruvbox_plain

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor

object SharedColorSettings {
    val additionalHighlightingTagToDescriptorMap: Map<String, TextAttributesKey> = mapOf(
        "keyword" to keywordHighlighting,
        "primitive-type" to typeHighlighting,
        "language-constant" to languageConstantHighlighting,
        "punctuation" to punctuationHighlighting,
    )

    val attributeDescriptors = arrayOf(
        AttributesDescriptor("Keyword", keywordHighlighting),
        AttributesDescriptor("Primitive type", typeHighlighting),
        AttributesDescriptor("Language constant", languageConstantHighlighting),
        AttributesDescriptor("Punctuation", punctuationHighlighting),
    )
}
