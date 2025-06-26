package dev.hermannm.gruvboxplain

import com.intellij.psi.PsiElement
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
