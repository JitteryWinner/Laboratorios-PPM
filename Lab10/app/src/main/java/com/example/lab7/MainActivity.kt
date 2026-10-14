package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { AppRickMorty() } }
    }
}

@Composable
fun AppRickMorty() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val sesion = remember(context) { SesionDatos(context) }
    val scope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = InicioDestinos) {
        composable<InicioDestinos> {
            LaunchedEffect(Unit) {
                val nombre = sesion.nombre.first()
                navController.navigate(if (nombre.isNullOrBlank()) LoginDestinos else MainDestinos) {
                    popUpTo<InicioDestinos> { inclusive = true }
                    launchSingleTop = true
                }
            }
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        composable<LoginDestinos> {
            PantallaLogin(onStartClick = { nombre ->
                scope.launch {
                    sesion.iniciarSesion(nombre)
                    navController.navigate(MainDestinos) {
                        popUpTo<LoginDestinos> { inclusive = true }
                        launchSingleTop = true
                    }
                }
            })
        }
        composable<MainDestinos> {
            MainScreen(sesion = sesion, onLogout = {
                scope.launch {
                    sesion.cerrarSesion()
                    navController.navigate(LoginDestinos) {
                        popUpTo<MainDestinos> { inclusive = true }
                        launchSingleTop = true
                    }
                }
            })
        }
    }
}
