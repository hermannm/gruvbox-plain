package dev.hermannm.gruvbox_plain.csharp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.highlight
import dev.hermannm.gruvbox_plain.isGenericBracket
import dev.hermannm.gruvbox_plain.keywordHighlighting
import dev.hermannm.gruvbox_plain.punctuationHighlighting
import dev.hermannm.gruvbox_plain.typeHighlighting
import dev.hermannm.gruvbox_plain.valueHighlighting

class CsharpAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "=>", "?", "!" -> keywordHighlighting
            "this", "true", "false", "null" -> valueHighlighting
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
            "ulong",
            "short",
            "ushort",
            "void",
            -> typeHighlighting
            ":" -> punctuationHighlighting
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            else -> return
        }

        element.highlight(highlighting, annotationHolder)
    }
}
