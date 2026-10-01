package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {
                Lab7()
            }
        }
    }
}

@Composable
fun Lab7() {

    val navController = rememberNavController()

    val characterDb = remember {
        CharacterDb()
    }

    NavHost(
        navController = navController,
        startDestination = LoginDestination
    ) {

        composable<LoginDestination> {

            PantallaLogin(
                onStartClick = {

                    navController.navigate(
                        CharactersDestination
                    ) {

                        popUpTo<LoginDestination> {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        composable<CharactersDestination> {

            PantallaPersonajes(
                characters = characterDb.getAllCharacters(),
                onCharacterClick = { id ->

                    navController.navigate(
                        CharacterDetailsDestination(
                            id = id
                        )
                    )
                }
            )
        }

        composable<CharacterDetailsDestination> { backStackEntry ->

            val destination =
                backStackEntry.toRoute<CharacterDetailsDestination>()

            val character =
                characterDb.getCharacterById(
                    destination.id
                )

            Detalles(
                character = character,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}