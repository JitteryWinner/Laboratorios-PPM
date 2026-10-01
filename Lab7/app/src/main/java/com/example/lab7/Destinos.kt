package com.example.lab7

import kotlinx.serialization.Serializable

// ROOT

@Serializable
object LoginDestinos

@Serializable
object MainDestinos


// CHARACTERS NESTED GRAPH

@Serializable
object CharactersGraph

@Serializable
object CharactersDestinos

@Serializable
data class CharacterDetailsDestinos(
    val id: Int
)


// LOCATIONS NESTED GRAPH

@Serializable
object LocationsGraph

@Serializable
object LocationsDestinos

@Serializable
data class LocationDetailsDestinos(
    val id: Int
)


// PROFILE

@Serializable
object ProfileDestinos