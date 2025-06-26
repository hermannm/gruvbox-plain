@file:Suppress("DialogTitleCapitalization")

package dev.hermannm.gruvboxplain.java

import com.intellij.ide.highlighter.JavaFileHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import dev.hermannm.gruvboxplain.BaseColorSettingsPage

public class JavaColorSettingsPage : BaseColorSettingsPage() {
  override fun getDisplayName(): String = "Java (gruvbox-plain)"

  override fun getDemoText(): String {
    return """
            <type>boolean</type> isDemo <keyword>=</keyword> <value>true</value><punctuation>;</punctuation>
        """
        .trimIndent()
  }

  override fun getHighlighter(): SyntaxHighlighter = JavaFileHighlighter()
}
