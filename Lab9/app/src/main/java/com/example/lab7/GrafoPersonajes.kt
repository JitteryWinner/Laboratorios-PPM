package com.example.lab7

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.grafoPersonajes(navController: NavHostController, characterDb: CharacterDb) {
    navigation<CharactersGraph>(startDestination = CharactersDestinos) {
        composable<CharactersDestinos> {
            val vm: PersonajesViewModel = viewModel()
            val estado by vm.estado.collectAsStateWithLifecycle()
            ContenidoConEstado(estado, "Error al obtener listado de personajes.\nIntenta de nuevo", vm::mostrarError, vm::cargar) { personajes ->
                PantallaPersonajes(
                    characters = personajes,
                    onCharacterClick = { id -> navController.navigate(CharacterDetailsDestinos(id)) }
                )
            }
        }
        composable<CharacterDetailsDestinos> {
            val vm: DetallePersonajeViewModel = viewModel()
            val estado by vm.estado.collectAsStateWithLifecycle()
            ContenidoConEstado(estado, "Error al obtener personaje.\nIntenta de nuevo", vm::mostrarError, vm::cargar) { personaje ->
                Detalles(character = personaje, onBackClick = { navController.popBackStack() })
            }
        }
    }
}
