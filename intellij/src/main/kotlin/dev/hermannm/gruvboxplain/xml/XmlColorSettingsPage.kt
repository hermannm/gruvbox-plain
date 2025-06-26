@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.xml

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class XmlColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "XML (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <punctuation>\<</punctuation><type>isDemo</type><punctuation>\>/punctuation>true<punctuation>\<\\</punctuation><type>isDemo</type><punctuation>\>/punctuation>
        """
        .trimIndent()
  }
}
