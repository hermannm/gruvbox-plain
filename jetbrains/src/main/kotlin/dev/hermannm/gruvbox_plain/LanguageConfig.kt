package dev.hermannm.gruvbox_plain

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class LanguageConfig(name: String, constantKeywords: Array<String>, primitiveKeywords: Array<String>) {
    val constants = HighlightingConfig(
        keywords = constantKeywords,
        highlighting = TextAttributesKey.createTextAttributesKey(
            "CUSTOM_${name.uppercase()}_LANGUAGE_CONSTANT", DefaultLanguageHighlighterColors.STRING
        ),
        descriptor = "$name language constant",
        demoTextTag = "${name.lowercase()}-language-constant"
    )

    val primitives = HighlightingConfig(
        keywords = primitiveKeywords,
        highlighting = TextAttributesKey.createTextAttributesKey(
            "CUSTOM_${name.uppercase()}_PRIMITIVE", DefaultLanguageHighlighterColors.CLASS_NAME
        ),
        descriptor = "$name primitive type",
        demoTextTag = "${name.lowercase()}-primitive"
    )
}
