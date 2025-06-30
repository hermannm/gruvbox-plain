package dev.hermannm.gruvboxplain

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.util.nextLeaf
import com.intellij.psi.util.prevLeaf

/**
 * Parameter passed to [BaseAnnotator].
 *
 * Annotators may be instantiated multiple times:
 * https://intellij-support.jetbrains.com/hc/en-us/community/posts/20963089597586-Can-t-figure-out-why-I-have-two-instances-of-annotator
 *
 * So to avoid re-allocating this array, you should define it as a static top-level variable.
 */
internal typealias HighlightingConfig = Array<HighlightingGroup>

/**
 * Will apply [highlighting] to elements with text matching one of [symbols] and where [applyIf]
 * returns true. If [applyIf] is `null`, only [symbols] is checked, and vice-versa.
 *
 * [symbols] and [applyIf] should not both be `null`.
 */
internal class HighlightingGroup(
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
            // We don't want to match less than/greater than operators (as we still want those to
            // use keyword highlighting). These will typically be preceded and followed by a space,
            // so we use that to selectively apply this highlighting.
            applyIf = { element -> !element.prevLeaf().isSpace() || !element.nextLeaf().isSpace() },
        )
  }
}

internal enum class Highlighting(@JvmField val textAttributesKey: TextAttributesKey) {
  KEYWORD(DefaultLanguageHighlighterColors.KEYWORD),
  TYPE(DefaultLanguageHighlighterColors.CLASS_NAME),
  FUNCTION(DefaultLanguageHighlighterColors.FUNCTION_CALL),
  VALUE(DefaultLanguageHighlighterColors.STRING),
  PUNCTUATION(DefaultLanguageHighlighterColors.BRACES),
}
