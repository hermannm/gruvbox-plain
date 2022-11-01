package dev.hermannm.gruvbox_plain.java

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import dev.hermannm.gruvbox_plain.genericBracketHighlighting
import dev.hermannm.gruvbox_plain.genericBrackets
import dev.hermannm.gruvbox_plain.highlightElement

private val javaPrimitives = arrayOf(
    "char", "boolean", "int", "char", "float", "double", "long", "short", "byte", "void"
)

private val javaLanguageConstants = arrayOf(
    "this", "true", "false", "null"
)

internal val javaPrimitiveHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_JAVA_PRIMITIVE", DefaultLanguageHighlighterColors.CLASS_NAME
)

internal val javaLanguageConstantHighlighting = TextAttributesKey.createTextAttributesKey(
    "CUSTOM_JAVA_LANGUAGE_CONSTANT", DefaultLanguageHighlighterColors.STRING
)

private class JavaAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when {
            javaPrimitives.any { element.textMatches(it) } -> javaPrimitiveHighlighting
            javaLanguageConstants.any { element.textMatches(it) } -> javaLanguageConstantHighlighting
            genericBrackets.any { element.textMatches(it) } -> genericBracketHighlighting
            else -> null
        }

        highlighting?.let { highlightElement(it, element, annotationHolder) }
    }
}
