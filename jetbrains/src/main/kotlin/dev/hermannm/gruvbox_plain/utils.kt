package dev.hermannm.gruvbox_plain

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.psi.PsiElement

fun findCustomHighlighting(element: PsiElement, language: LanguageConfig?): TextAttributesKey? {
    for (config in sharedHighlightingConfig) {
        if (config.keywords.any { element.textMatches(it) }) return config.highlighting
    }

    language ?: return null

    return when {
        language.primitives.keywords.any { element.textMatches(it) } -> language.primitives.highlighting
        language.constants.keywords.any { element.textMatches(it) } -> language.constants.highlighting
        else -> null
    }
}

fun highlightElement(
    highlighting: TextAttributesKey,
    element: PsiElement,
    annotationHolder: AnnotationHolder,
) {
    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
        .range(element)
        .textAttributes(highlighting)
        .create()
}

fun getAttributeDescriptors(language: LanguageConfig?): Array<AttributesDescriptor> {
    val languageHighlighting =
        if (language != null) listOf(language.constants, language.primitives)
        else emptyList()

    val highlighting = languageHighlighting + sharedHighlightingConfig
    return highlighting.map { AttributesDescriptor(it.descriptor, it.highlighting) }.toTypedArray()
}

fun mapDemoTextTagToHighlighting(language: LanguageConfig?): Map<String, TextAttributesKey> {
    val map = mutableMapOf<String, TextAttributesKey>()

    if (language != null) {
        map[language.primitives.demoTextTag] = language.primitives.highlighting
        map[language.constants.demoTextTag] = language.constants.highlighting
    }

    for (config in sharedHighlightingConfig) {
        map[config.demoTextTag] = config.highlighting
    }

    return map
}
