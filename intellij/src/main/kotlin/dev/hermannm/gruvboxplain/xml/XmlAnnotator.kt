package dev.hermannm.gruvboxplain.xml

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup

private val XML_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.KEYWORD,
            symbols = arrayOf("="),
        ),
    )

class XmlAnnotator : BaseAnnotator(XML_HIGHLIGHTING_CONFIG)
