@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.js

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class JsColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "JavaScript (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <keyword>const</keyword> isDemo<punctuation>:</punctuation> <type>boolean</type> <keyword>=</keyword> <value>true</value><punctuation>;</punctuation>
        """
        .trimIndent()
  }
}
