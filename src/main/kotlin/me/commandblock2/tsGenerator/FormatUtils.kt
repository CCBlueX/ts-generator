package me.commandblock2.tsGenerator

import kotlin.reflect.KClass
import kotlin.reflect.KTypeParameter

fun KClass<*>.binaryName(): String {
    val fullName = this.java.name
    return fullName.substring(fullName.lastIndexOf('.') + 1)
}

// kotlin-reflect 2.4 throws on some JDK-internal generic signatures (ClassSpecializer.SpeciesData)
fun KClass<*>.safeTypeParameters(): List<KTypeParameter> =
    try {
        typeParameters
    } catch (_: Throwable) {
        emptyList()
    }

fun String.commentIfInvalid(): String {
    return if (this.contains('-')) "// $this // ; invalid because of -" else this
}