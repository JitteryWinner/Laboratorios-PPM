package com.example.lab7

import androidx.navigation.NavHostController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute

fun NavGraphBuilder.grafoPersonajes(
    navController: NavHostController,
    characterDb: CharacterDb
) {

    navigation<CharactersGraph>(
        startDestination = CharactersDestinos
    ) {

        composable<CharactersDestinos> {

            PantallaPersonajes(
                characters = characterDb.getAllCharacters(),
                onCharacterClick = { id ->

                    navController.navigate(
                        CharacterDetailsDestinos(
                            id = id
                        )
                    )
                }
            )
        }

        composable<CharacterDetailsDestinos> { backStackEntry ->

            val destino =
                backStackEntry.toRoute<CharacterDetailsDestinos>()

            val personaje =
                characterDb.getCharacterById(
                    destino.id
                )

            Detalles(
                character = personaje,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}