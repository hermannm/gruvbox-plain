package dev.hermannm.gruvboxplain.rust

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup

private val RUST_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf(":", "::"),
        ),
        HighlightingGroup.GENERIC_BRACKETS,
    )

public class RustAnnotator : BaseAnnotator(RUST_HIGHLIGHTING_CONFIG)
