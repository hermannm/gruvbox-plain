package dev.hermannm.gruvbox_plain.java

import com.intellij.ide.highlighter.JavaFileHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon
import dev.hermannm.gruvbox_plain.getAttributeDescriptors
import dev.hermannm.gruvbox_plain.mapDemoTextTagToHighlighting

class JavaColorSettingsPage : ColorSettingsPage {
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = getAttributeDescriptors(javaLanguageConfig)

    override fun getDisplayName(): String = "Java (Primitives & Constants)"

    override fun getDemoText(): String {
        return """
            <java-primitive>boolean</java-primitive> isDemo = <java-language-constant>true</java-language-constant>;
        """.trimIndent()
    }

    override fun getHighlighter(): SyntaxHighlighter = JavaFileHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> =
        mapDemoTextTagToHighlighting(javaLanguageConfig)

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
