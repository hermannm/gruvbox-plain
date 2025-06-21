package dev.hermannm.gruvboxplain.xml

import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup

class XmlAnnotator : BaseAnnotator(CONFIG) {
  companion object {
    private val CONFIG: HighlightingConfig =
        arrayOf(
            HighlightingGroup(
                Highlighting.KEYWORD,
                symbols = arrayOf("="),
            ),
        )
  }
}
