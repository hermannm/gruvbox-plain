@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.rust

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class RustColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "Rust (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <keyword>let</keyword> isDemo<punctuation>:</punctuation> <type>bool</type> <keyword>=</keyword> <value>true</value><punctuation>;</punctuation>
        """
        .trimIndent()
  }
}
