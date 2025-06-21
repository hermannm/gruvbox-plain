package dev.hermannm.gruvboxplain.xml

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingGroup

class XmlAnnotator :
    BaseAnnotator(
        highlightingGroups =
            arrayOf(
                HighlightingGroup(
                    Highlighting.KEYWORD,
                    symbols = arrayOf("="),
                ),
            ),
    )
