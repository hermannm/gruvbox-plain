package dev.hermannm.gruvboxplain

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

abstract class BaseColorSettingsPage : ColorSettingsPage {
  override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
    return ATTRIBUTE_DESCRIPTORS
  }

  override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
    return ADDITIONAL_HIGHLIGHTING_TAG_TO_DESCRIPTOR_MAP
  }

  override fun getHighlighter(): SyntaxHighlighter = PlainSyntaxHighlighter()

  override fun getIcon(): Icon? = null

  override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

  companion object {
    @JvmField
    val ADDITIONAL_HIGHLIGHTING_TAG_TO_DESCRIPTOR_MAP: Map<String, TextAttributesKey> =
        mapOf(
            "keyword" to Highlighting.KEYWORD.textAttributesKey,
            "type" to Highlighting.TYPE.textAttributesKey,
            "function" to Highlighting.FUNCTION.textAttributesKey,
            "value" to Highlighting.VALUE.textAttributesKey,
            "punctuation" to Highlighting.PUNCTUATION.textAttributesKey,
        )

    @JvmField
    val ATTRIBUTE_DESCRIPTORS =
        arrayOf(
            AttributesDescriptor("Keyword", Highlighting.KEYWORD.textAttributesKey),
            AttributesDescriptor("Type", Highlighting.TYPE.textAttributesKey),
            AttributesDescriptor("Function", Highlighting.FUNCTION.textAttributesKey),
            AttributesDescriptor("Value", Highlighting.VALUE.textAttributesKey),
            AttributesDescriptor("Punctuation", Highlighting.PUNCTUATION.textAttributesKey),
        )
  }
}
