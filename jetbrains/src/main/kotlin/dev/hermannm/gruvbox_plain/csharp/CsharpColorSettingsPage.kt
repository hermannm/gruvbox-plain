package dev.hermannm.gruvbox_plain.csharp

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.hermannm.gruvbox_plain.SharedColorSettings
import javax.swing.Icon

class CsharpColorSettingsPage : ColorSettingsPage {
    override fun getDisplayName(): String = "C# (gruvbox-plain)"

    override fun getDemoText(): String {
        return """
            <primitive-type>bool</primitive-type> isDemo = <language-constant>true</language-constant>;
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
