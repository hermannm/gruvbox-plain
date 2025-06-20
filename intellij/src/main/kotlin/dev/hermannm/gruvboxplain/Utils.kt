package dev.hermannm.gruvboxplain

import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

fun PsiElement.name(): String {
    return this.elementType.toString()
}
