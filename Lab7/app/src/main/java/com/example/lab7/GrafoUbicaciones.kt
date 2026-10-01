package com.example.lab7

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute

fun NavGraphBuilder.grafoUbicaciones(
    navController: NavHostController,
    locationDb: LocationDb
) {

    navigation<LocationsGraph>(
        startDestination = LocationsDestinos
    ) {

        composable<LocationsDestinos> {

            PantallaUbicaciones(
                locations = locationDb.getAllLocations(),
                onLocationClick = { id ->

                    navController.navigate(
                        LocationDetailsDestinos(
                            id = id
                        )
                    )
                }
            )
        }

        composable<LocationDetailsDestinos> { backStackEntry ->

            val destino =
                backStackEntry.toRoute<LocationDetailsDestinos>()

            val location =
                locationDb.getLocationById(
                    destino.id
                )

            PantallaDetalleUbicacion(
                location = location,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}