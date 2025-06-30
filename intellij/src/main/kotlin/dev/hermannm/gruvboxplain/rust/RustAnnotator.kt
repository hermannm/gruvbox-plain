package dev.hermannm.gruvboxplain.rust

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.BaseAnnotator
import dev.hermannm.gruvboxplain.Highlighting
import dev.hermannm.gruvboxplain.HighlightingConfig
import dev.hermannm.gruvboxplain.HighlightingGroup
import dev.hermannm.gruvboxplain.highlightChildIdentifiers
import dev.hermannm.gruvboxplain.name

private val RUST_HIGHLIGHTING_CONFIG: HighlightingConfig =
    arrayOf(
        HighlightingGroup(
            Highlighting.PUNCTUATION,
            symbols = arrayOf(":", "::", "#"),
        ),
        HighlightingGroup.GENERIC_BRACKETS,
    )

public class RustAnnotator : BaseAnnotator(RUST_HIGHLIGHTING_CONFIG) {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    when (element.name()) {
      // Use type highlighting for all identifiers in attribute macros and `use` statements
      "OUTER_ATTR",
      "USE_ITEM" -> {
        highlightChildIdentifiers(
            Highlighting.TYPE,
            identifierElementName = "identifier",
            element,
            annotationHolder,
        )
      }
      else -> {
        super.annotate(element, annotationHolder)
      }
    }
  }
}
