@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.xml

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.hermannm.gruvboxplain.SharedColorSettings
import javax.swing.Icon

class XmlColorSettingsPage : ColorSettingsPage {
    override fun getDisplayName(): String = "XML (gruvbox-plain)"

    override fun getDemoText(): String {
        return """
            <punctuation>\<</punctuation><type>isDemo</type><punctuation>\>/punctuation>true<punctuation>\<\\</punctuation><type>isDemo</type><punctuation>\>/punctuation>
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
