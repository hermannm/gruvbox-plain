package dev.hermannm.gruvboxplain

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor

object SharedColorSettings {
    val additionalHighlightingTagToDescriptorMap: Map<String, TextAttributesKey> = mapOf(
        "keyword" to keywordHighlighting,
        "type" to typeHighlighting,
        "function" to functionHighlighting,
        "value" to valueHighlighting,
        "punctuation" to punctuationHighlighting,
    )

    val attributeDescriptors = arrayOf(
        AttributesDescriptor("Keyword", keywordHighlighting),
        AttributesDescriptor("Type", typeHighlighting),
        AttributesDescriptor("Function", functionHighlighting),
        AttributesDescriptor("Value", valueHighlighting),
        AttributesDescriptor("Punctuation", punctuationHighlighting),
    )
}
