package io.github.edgeatzero.booksource.preferences

/**
 *  ๅก็้้กน
 * */
public data class CardPreference(
    public val preferences: List<Preference>
) : Preference {
    public constructor(vararg preference: Preference) : this(preference.toList())
}