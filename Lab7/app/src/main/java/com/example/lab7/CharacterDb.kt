package com.example.lab7

class CharacterDb {

    private val characters: List<Character> = listOf(
        Character(1, "Rick Sanchez (C-137)", "Vivo", "Humano", "Hombre", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        Character(2, "Morty Smith (Prime)", "Vivo", "Humano", "Hombre", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
        Character(3, "Summer Smith (C-131)", "Vivo", "Humano", "Mujer", "https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
        Character(4, "Beth Smith (C-131)", "Vivo", "Humano", "Mujer", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
        Character(5, "Jerry Smith (5126)", "Vivo", "Humano", "Hombre", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
        Character(21, "Rick Prime (Prime)", "Muerto", "Humano", "Hombre", "https://rickandmortyapi.com/api/character/avatar/285.jpeg"),

    )

    fun getAllCharacters(): List<Character> {
        return characters
    }

    fun getCharacterById(id: Int): Character {
        return characters.first { it.id == id }
    }
}