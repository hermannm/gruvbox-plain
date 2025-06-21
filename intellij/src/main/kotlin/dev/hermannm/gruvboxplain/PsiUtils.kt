package dev.hermannm.gruvboxplain

import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.intellij.psi.util.prevLeaf

fun PsiElement.name(): String? {
  return this.elementType?.toString()
}

fun PsiElement.previousNonSpaceLeaf(): PsiElement? {
  return this.prevLeaf(filter = { !it.textMatches(" ") })
}

fun PsiElement.nextNonSpaceLeaf(): PsiElement? {
  return this.nextLeaf(filter = { !it.textMatches(" ") })
}
