package dev.hermannm.gruvbox_plain.kotlin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon
import dev.hermannm.gruvbox_plain.getAttributeDescriptors
import dev.hermannm.gruvbox_plain.mapDemoTextTagToHighlighting

class KotlinColorSettingsPage : ColorSettingsPage {
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = getAttributeDescriptors(kotlinLanguageConfig)

    override fun getDisplayName(): String = "Kotlin (Primitives & Constants)"

    override fun getDemoText(): String {
        return """
            val isDemo: <kotlin-primitive>Boolean</kotlin-primitive> = <kotlin-language-constant>true</kotlin-language-constant>
        """.trimIndent()
    }
    
    override fun getHighlighter(): SyntaxHighlighter = PlainSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> =
        mapDemoTextTagToHighlighting(kotlinLanguageConfig)

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
