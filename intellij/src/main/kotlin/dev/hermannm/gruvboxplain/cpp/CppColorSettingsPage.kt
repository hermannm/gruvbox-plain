@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.cpp

import dev.hermannm.gruvboxplain.BaseColorSettingsPage

class CppColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "C++ (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <type>bool</type> isDemo <keyword>=</keyword> <value>true</value><punctuation>;</punctuation>
        """
        .trimIndent()
  }
}
