package dev.hermannm.gruvboxplain.kotlin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childLeafs
import com.intellij.psi.util.elementType
import dev.hermannm.gruvboxplain.*

class KotlinAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        when (element.name()) {
            // If element is a package/import declaration, we highlight package path elements
            "PACKAGE_DIRECTIVE",
            "IMPORT_LIST" -> {
                element.highlightChildIdentifiers(typeHighlighting, annotationHolder)
                return
            }
        }

        val highlighting = when (element.text) {
            "?:", "=" -> keywordHighlighting
            "this", "true", "false", "null" -> valueHighlighting
            "@" -> typeHighlighting
            "<", ">" -> if (element.isGenericBracket()) punctuationHighlighting else return
            "." -> return
            else -> return
        }

        element.highlight(highlighting, annotationHolder)
    }
}

/** Applies the given highlighting to all child leaf elements of type 'IDENTIFIER'. */
fun PsiElement.highlightChildIdentifiers(
    highlighting: TextAttributesKey,
    annotationHolder: AnnotationHolder,
) {
    for (childElement in this.childLeafs()) {
        if (childElement.elementType.toString() == "IDENTIFIER") {
            childElement.highlight(highlighting, annotationHolder)
        }
    }
}
