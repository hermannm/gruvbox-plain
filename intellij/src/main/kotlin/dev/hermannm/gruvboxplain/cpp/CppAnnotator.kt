package dev.hermannm.gruvboxplain.cpp

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.name

class CppAnnotator : BaseAnnotator(CONFIG) {
  companion object {
    private val CONFIG: HighlightingConfig =
        arrayOf(
            HighlightingGroup(
                Highlighting.VALUE,
                symbols = arrayOf("this", "true", "false", "nullptr"),
            ),
            HighlightingGroup(
                Highlighting.TYPE,
                symbols =
                    arrayOf(
                        "int",
                        "char",
                        "bool",
                        "float",
                        "double",
                        "void",
                        "long",
                        "short",
                        "signed",
                        "unsigned",
                    ),
            ),
            HighlightingGroup(
                Highlighting.FUNCTION,
                symbols = arrayOf("sizeof"),
            ),
            HighlightingGroup(
                Highlighting.FUNCTION,
                symbols = arrayOf(":", "::", "->"),
            ),
            HighlightingGroup.GENERIC_BRACKETS,
            HighlightingGroup(
                Highlighting.PUNCTUATION,
                applyIf = { element ->
                  element.name() == "IDENTIFIER" &&
                      element.parent?.javaClass?.simpleName == "OCAttributeImpl"
                },
            ),
        )
  }
}
