package dev.hermannm.gruvbox_plain.java

import com.intellij.ide.highlighter.JavaFileHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.hermannm.gruvbox_plain.genericBracketHighlighting
import dev.hermannm.gruvbox_plain.genericBracketsDescriptor
import javax.swing.Icon

private class JavaColorSettingsPage : ColorSettingsPage {
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return arrayOf(
            AttributesDescriptor("Java primitive type", javaPrimitiveHighlighting),
            AttributesDescriptor("Java language constant", javaLanguageConstantHighlighting),
            genericBracketsDescriptor,
        )
    }

    override fun getDisplayName(): String = "Java (Primitives & Constants)"

    override fun getDemoText(): String {
        return """
            <java-primitive>boolean</java-primitive> isDemo = <java-language-constant>true</java-language-constant>;
            List<generic-brackets><</generic-brackets>String<generic-brackets>></generic-brackets> list;
        """.trimIndent()
    }

    override fun getHighlighter(): SyntaxHighlighter = JavaFileHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return mapOf(
            "java-primitive" to javaPrimitiveHighlighting,
            "java-language-constant" to javaLanguageConstantHighlighting,
            "generic-brackets" to genericBracketHighlighting
        )
    }

    override fun getIcon(): Icon? = null

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
}
