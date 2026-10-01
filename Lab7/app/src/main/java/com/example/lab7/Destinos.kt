package com.example.lab7

import kotlinx.serialization.Serializable

@Serializable
object LoginDestination

@Serializable
object CharactersDestination

@Serializable
data class CharacterDetailsDestination(
    val id: Int
)