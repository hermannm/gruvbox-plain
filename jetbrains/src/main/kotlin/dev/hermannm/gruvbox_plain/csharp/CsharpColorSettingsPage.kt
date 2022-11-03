package dev.hermannm.gruvbox_plain.csharp

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon
import dev.hermannm.gruvbox_plain.getAttributeDescriptors
import dev.hermannm.gruvbox_plain.mapDemoTextTagToHighlighting

class CsharpColorSettingsPage : ColorSettingsPage {
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = getAttributeDescriptors(csharpLanguageConfig)

    override fun getDisplayName(): String = "C# (Primitives & Constants)"

    override fun getDemoText(): String {
        return """
            <csharp-primitive>bool</csharp-primitive> isDemo = <csharp-language-constant>true</csharp-language-constant>;
        """.trimIndent()
    }

    override fun getHighlighter(): SyntaxHighlighter = PlainSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> =
        mapDemoTextTagToHighlighting(csharpLanguageConfig)

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
