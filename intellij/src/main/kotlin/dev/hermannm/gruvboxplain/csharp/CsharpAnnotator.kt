package dev.hermannm.gruvboxplain.csharp

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup

private val CSHARP_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.KEYWORD,
            symbols = arrayOf("=>", "?", "??", "??=", "!"),
        ),
        HighlightingGroup(
            Highlighting.VALUE,
            symbols = arrayOf("this", "true", "false", "null"),
        ),
        HighlightingGroup(
            Highlighting.TYPE,
            symbols =
                arrayOf(
                    "object",
                    "string",
                    "dynamic",
                    "bool",
                    "byte",
                    "sbyte",
                    "char",
                    "decimal",
                    "double",
                    "float",
                    "int",
                    "uint",
                    "nint",
                    "nuint",
                    "long",
                    "ulong",
                    "short",
                    "ushort",
                    "void",
                ),
        ),
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf(":"),
        ),
        HighlightingGroup.GENERIC_BRACKETS,
    )

public class CsharpAnnotator : BaseAnnotator(CSHARP_HIGHLIGHTING_CONFIG)
