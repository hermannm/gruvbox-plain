package dev.hermannm.gruvbox_plain.java

import com.intellij.ide.highlighter.JavaFileHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.hermannm.gruvbox_plain.SharedColorSettings
import javax.swing.Icon

class JavaColorSettingsPage : ColorSettingsPage {
    override fun getDisplayName(): String = "Java (gruvbox-plain)"

    override fun getDemoText(): String {
        return """
            <primitive-type>boolean</primitive-type> isDemo = <language-constant>true</language-constant>;
        """.trimIndent()
    }

    override fun getHighlighter(): SyntaxHighlighter = JavaFileHighlighter()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return SharedColorSettings.attributeDescriptors
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return SharedColorSettings.additionalHighlightingTagToDescriptorMap
    }

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
