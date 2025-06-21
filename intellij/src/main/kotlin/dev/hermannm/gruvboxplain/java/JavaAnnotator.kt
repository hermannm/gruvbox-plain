package dev.hermannm.gruvboxplain.java

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup

class JavaAnnotator : BaseAnnotator(CONFIG) {
  companion object {
    private val CONFIG: HighlightingConfig =
        arrayOf(
            HighlightingGroup(
                Highlighting.KEYWORD,
                symbols = arrayOf("->"),
            ),
            HighlightingGroup(
                Highlighting.VALUE,
                symbols = arrayOf("this", "true", "false", "null"),
            ),
            HighlightingGroup(
                Highlighting.TYPE,
                symbols =
                    arrayOf(
                        "char",
                        "boolean",
                        "int",
                        "float",
                        "double",
                        "long",
                        "short",
                        "byte",
                        "void",
                    ),
            ),
            HighlightingGroup(
                Highlighting.PUNCTUATION,
                symbols = arrayOf("::"),
            ),
            HighlightingGroup.GENERIC_BRACKETS,
        )
  }
}
