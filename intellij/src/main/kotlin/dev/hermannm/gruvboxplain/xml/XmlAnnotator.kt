package dev.hermannm.gruvboxplain.xml

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvboxplain.highlight
import dev.hermannm.gruvboxplain.keywordHighlighting

class XmlAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "=" -> keywordHighlighting
            else -> return
        }

        element.highlight(highlighting, annotationHolder)
    }
}
