package dev.hermannm.gruvbox_plain.csharp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.LanguageConfig
import dev.hermannm.gruvbox_plain.findCustomHighlighting
import dev.hermannm.gruvbox_plain.highlightElement

internal val csharpLanguageConfig = LanguageConfig(
    name = "CSharp",
    constantKeywords = arrayOf("this", "true", "false", "null"),
    primitiveKeywords = arrayOf(
        "object",
        "string",
        "dynamic",
        "bool",
        "byte",
        "sbyte",
        "char",
        "decimal",
        "double",
        "float",
        "int",
        "uint",
        "nint",
        "nuint",
        "long",
        "long",
        "ulong",
        "short",
        "ushort",
        "void"
    ),
)

class CsharpAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = findCustomHighlighting(element, csharpLanguageConfig) ?: return
        highlightElement(highlighting, element, annotationHolder)
    }
}