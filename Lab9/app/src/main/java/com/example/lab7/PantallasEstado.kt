package com.example.lab7

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaCargando(onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(color = Color(0xFF51599A))
            Spacer(Modifier.height(12.dp))
            Text("Cargando", color = Color.Black)
        }
    }
}

@Composable
fun PantallaError(mensaje: String, onReintentar: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Text("!", fontSize = 36.sp, color = Color(0xFFB43122))
            Spacer(Modifier.height(16.dp))
            Text(mensaje, textAlign = TextAlign.Center, color = Color(0xFFB43122))
            Spacer(Modifier.height(14.dp))
            OutlinedButton(onClick = onReintentar) { Text("Reintentar") }
        }
    }
}

@Composable
fun <T> ContenidoConEstado(
    estado: EstadoPantalla<T>,
    mensajeError: String,
    onError: () -> Unit,
    onReintentar: () -> Unit,
    contenido: @Composable (T) -> Unit
) {
    when {
        estado.hasError -> PantallaError(mensajeError, onReintentar)
        estado.isLoading -> PantallaCargando(onError)
        estado.data != null -> contenido(estado.data)
        else -> PantallaError(mensajeError, onReintentar)
    }
}
