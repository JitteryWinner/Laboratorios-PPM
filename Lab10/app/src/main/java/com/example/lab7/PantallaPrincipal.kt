package com.example.lab7
import androidx.compose.material3.MaterialTheme
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class PestanaPrincipal {
    PERSONAJES,
    UBICACIONES,
    PERFIL
}

@Composable
fun MainScreen(
    sesion: SesionDatos,
    onLogout: () -> Unit
) {

    val navController = rememberNavController()
    val nombre by sesion.nombre.collectAsStateWithLifecycle(initialValue = null)
    val activity = LocalActivity.current
    val entrada by navController.currentBackStackEntryAsState()
    BackHandler(enabled = entrada?.destination?.route == CharactersDestinos::class.qualifiedName == true) {
        activity?.finish()
    }

    val characterDb = remember {
        CharacterDb()
    }

    val locationDb = remember {
        LocationDb()
    }

    var pestanaSeleccionada by rememberSaveable {
        mutableStateOf(
            PestanaPrincipal.PERSONAJES
        )
    }

    Scaffold(
        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected =
                        pestanaSeleccionada ==
                                PestanaPrincipal.PERSONAJES,

                    onClick = {

                        pestanaSeleccionada =
                            PestanaPrincipal.PERSONAJES

                        navController.navigate(
                            CharactersGraph
                        ) {

                            popUpTo(
                                navController.graph.startDestinationId
                            )

                            launchSingleTop = true
                        }
                    },
                    icon = {

                        Icon(
                            imageVector = Icons.Default.People,
                            contentDescription = "Personajes"
                        )
                    },
                    label = {
                        Text("Personajes")
                    }
                )

                NavigationBarItem(
                    selected =
                        pestanaSeleccionada ==
                                PestanaPrincipal.UBICACIONES,

                    onClick = {

                        pestanaSeleccionada =
                            PestanaPrincipal.UBICACIONES

                        navController.navigate(
                            LocationsGraph
                        ) {

                            popUpTo(
                                navController.graph.startDestinationId
                            )

                            launchSingleTop = true
                        }
                    },
                    icon = {

                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Ubicaciones"
                        )
                    },
                    label = {
                        Text("Ubicaciones")
                    }
                )

                NavigationBarItem(
                    selected =
                        pestanaSeleccionada ==
                                PestanaPrincipal.PERFIL,

                    onClick = {

                        pestanaSeleccionada =
                            PestanaPrincipal.PERFIL

                        navController.navigate(
                            ProfileDestinos
                        ) {

                            popUpTo(
                                navController.graph.startDestinationId
                            )

                            launchSingleTop = true
                        }
                    },
                    icon = {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil"
                        )
                    },
                    label = {
                        Text("Perfil")
                    }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = CharactersGraph,
            modifier = Modifier.padding(
                paddingValues
            )
        ) {

            grafoPersonajes(
                navController = navController,
                characterDb = characterDb
            )

            grafoUbicaciones(
                navController = navController,
                locationDb = locationDb
            )

            composable<ProfileDestinos> {

                PantallaPerfil(
                    nombre = nombre.orEmpty(),
                    onLogout = onLogout
                )
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Pantalla Principal"
)
@Composable
fun PantallaPrincipalPreview() {

    MaterialTheme {

        val context = LocalContext.current
        MainScreen(
            sesion = remember { SesionDatos(context.applicationContext) },
            onLogout = {}
        )
    }
}