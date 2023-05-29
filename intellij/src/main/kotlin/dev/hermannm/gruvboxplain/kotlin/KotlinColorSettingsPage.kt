package dev.hermannm.gruvboxplain.kotlin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.hermannm.gruvboxplain.SharedColorSettings
import javax.swing.Icon

class KotlinColorSettingsPage : ColorSettingsPage {
    override fun getDisplayName(): String = "Kotlin (gruvbox-plain)"

    override fun getDemoText(): String {
        return """
            <keyword>val</keyword> isDemo<punctuation>:</punctuation> <type>Boolean</type> <keyword>=</keyword> <value>true</value>
        """.trimIndent()
    }

    override fun getHighlighter(): SyntaxHighlighter = PlainSyntaxHighlighter()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return SharedColorSettings.attributeDescriptors
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return SharedColorSettings.additionalHighlightingTagToDescriptorMap
    }

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
