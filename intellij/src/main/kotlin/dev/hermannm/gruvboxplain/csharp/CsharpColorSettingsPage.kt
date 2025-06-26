@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.csharp

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class CsharpColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "C# (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <type>bool</type> isDemo <keyword>=</keyword> <value>true</value><punctuation>;</punctuation>
        """
        .trimIndent()
  }
}
