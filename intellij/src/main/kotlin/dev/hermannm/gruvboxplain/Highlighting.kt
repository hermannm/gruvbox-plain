package dev.hermannm.gruvboxplain

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

/**
 * Parameter passed to [BaseAnnotator].
 *
 * Annotators may be instantiated multiple times:
 * https://intellij-support.jetbrains.com/hc/en-us/community/posts/20963089597586-Can-t-figure-out-why-I-have-two-instances-of-annotator
 *
 * So to avoid re-allocating this array, you should define it as a static field on the annotator's
 * companion object.
 */
typealias HighlightingConfig = Array<HighlightingGroup>

/**
 * Will apply [highlighting] to elements with text matching one of [symbols] and where [applyIf]
 * returns true. If [applyIf] is `null`, only [symbols] is checked, and vice-versa.
 *
 * [symbols] and [applyIf] should not both be `null`.
 */
class HighlightingGroup(
    @JvmField val highlighting: Highlighting,
    @JvmField val symbols: Array<String>? = null,
    @JvmField val applyIf: ((PsiElement) -> Boolean)? = null,
) {
  companion object {
    /** Highlighting groups for angle brackets around generic types, shared across languages. */
    @JvmField
    val GENERIC_BRACKETS =
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf("<", ">"),
            applyIf = { element -> !element.prevSibling.textMatches(" ") },
        )
  }
}

enum class Highlighting(@JvmField val textAttributesKey: TextAttributesKey) {
  KEYWORD(
      TextAttributesKey.createTextAttributesKey(
          "GRUVBOX_PLAIN_KEYWORD",
          DefaultLanguageHighlighterColors.KEYWORD,
      ),
  ),
  TYPE(
      TextAttributesKey.createTextAttributesKey(
          "GRUVBOX_PLAIN_TYPE",
          DefaultLanguageHighlighterColors.CLASS_NAME,
      ),
  ),
  FUNCTION(
      TextAttributesKey.createTextAttributesKey(
          "GRUVBOX_PLAIN_FUNCTION",
          DefaultLanguageHighlighterColors.FUNCTION_CALL,
      ),
  ),
  VALUE(
      TextAttributesKey.createTextAttributesKey(
          "GRUVBOX_PLAIN_VALUE",
          DefaultLanguageHighlighterColors.STRING,
      ),
  ),
  PUNCTUATION(
      TextAttributesKey.createTextAttributesKey(
          "GRUVBOX_PLAIN_PUNCTUATION",
          DefaultLanguageHighlighterColors.BRACES,
      ),
  ),
}
