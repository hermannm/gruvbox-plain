@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.kotlin

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class KotlinColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "Kotlin (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <keyword>val</keyword> isDemo<punctuation>:</punctuation> <type>Boolean</type> <keyword>=</keyword> <value>true</value>
        """
        .trimIndent()
  }
}
