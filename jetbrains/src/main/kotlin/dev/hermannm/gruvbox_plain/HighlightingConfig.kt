package dev.hermannm.gruvbox_plain

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class HighlightingConfig(
    val keywords: Array<String>,
    val highlighting: TextAttributesKey,
    val descriptor: String,
    val demoTextTag: String,
)

val sharedHighlightingConfig = listOf(
    HighlightingConfig(
        keywords = arrayOf("<", ">"),
        highlighting = TextAttributesKey.createTextAttributesKey(
            "CUSTOM_GENERIC_BRACKETS", DefaultLanguageHighlighterColors.BRACES
        ),
        descriptor = "Generic brackets",
        demoTextTag = "generic-brackets",
    )
)
