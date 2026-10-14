package com.example.lab7

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.grafoUbicaciones(navController: NavHostController, locationDb: LocationDb) {
    navigation<LocationsGraph>(startDestination = LocationsDestinos) {
        composable<LocationsDestinos> {
            val vm: UbicacionesViewModel = viewModel()
            val estado by vm.estado.collectAsStateWithLifecycle()
            ContenidoConEstado(estado, "Error al obtener listado de ubicaciones.\nIntenta de nuevo", vm::mostrarError, vm::cargar) { ubicaciones ->
                PantallaUbicaciones(
                    locations = ubicaciones,
                    onLocationClick = { id -> navController.navigate(LocationDetailsDestinos(id)) }
                )
            }
        }
        composable<LocationDetailsDestinos> {
            val vm: DetalleUbicacionViewModel = viewModel()
            val estado by vm.estado.collectAsStateWithLifecycle()
            ContenidoConEstado(estado, "Error al obtener ubicación.\nIntenta de nuevo", vm::mostrarError, vm::cargar) { ubicacion ->
                PantallaDetalleUbicacion(location = ubicacion, onBackClick = { navController.popBackStack() })
            }
        }
    }
}
