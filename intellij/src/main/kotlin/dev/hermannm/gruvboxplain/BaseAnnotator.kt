package dev.hermannm.gruvboxplain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

public open class BaseAnnotator
internal constructor(
    private val highlightingConfig: HighlightingConfig,
) : Annotator {
  override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
    for (group in highlightingConfig) {
      if ((group.symbols == null || group.symbols.any { element.textMatches(it) }) &&
          (group.applyIf == null || group.applyIf(element))) {
        applyHighlighting(group.highlighting, element, annotationHolder)
      }
    }
  }
}

internal fun applyHighlighting(
    highlighting: Highlighting,
    element: PsiElement,
    annotationHolder: AnnotationHolder
) {
  annotationHolder
      .newSilentAnnotation(HighlightSeverity.INFORMATION)
      .range(element)
      .textAttributes(highlighting.textAttributesKey)
      .create()
}
