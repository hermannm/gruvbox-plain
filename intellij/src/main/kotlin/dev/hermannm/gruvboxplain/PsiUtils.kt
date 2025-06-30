package dev.hermannm.gruvboxplain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childLeafs
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeaf

internal fun PsiElement.name(): String? {
  return this.elementType?.toString()
}

internal fun PsiElement.previousNonSpaceLeaf(): PsiElement? {
  return this.prevLeaf(filter = { !it.textMatches(" ") })
}

internal fun PsiElement?.isSpace(): Boolean {
  return this != null && textMatches(" ")
}

/**
 * Applies the given highlighting to all child leaf elements with the given identifier element name.
 */
internal fun highlightChildIdentifiers(
    highlighting: Highlighting,
    identifierElementName: String,
    element: PsiElement,
    annotationHolder: AnnotationHolder,
) {
  for (childElement in element.childLeafs()) {
    if (childElement.name() == identifierElementName) {
      applyHighlighting(highlighting, childElement, annotationHolder)
    }
  }
}
