package dev.hermannm.gruvboxplain.csharp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.isGenericBracket
import dev.hermannm.gruvboxplain.keywordHighlighting
import dev.hermannm.gruvboxplain.punctuationHighlighting
import dev.hermannm.gruvboxplain.typeHighlighting
import dev.hermannm.gruvboxplain.valueHighlighting

class CsharpAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "=>", "?", "??", "!" -> keywordHighlighting
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
