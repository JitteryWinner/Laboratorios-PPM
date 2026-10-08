package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {
                AppRickMorty()
            }
        }
    }
}

@Composable
fun AppRickMorty() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginDestinos
    ) {

        composable<LoginDestinos> {

            PantallaLogin(
                onStartClick = {

                    navController.navigate(
                        MainDestinos
                    ) {

                        popUpTo<LoginDestinos> {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        composable<MainDestinos> {

            MainScreen(
                onLogout = {

                    navController.navigate(
                        LoginDestinos
                    ) {

                        popUpTo<MainDestinos> {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }
    }
}