package com.example.lab7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPerfil(
    onLogout: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(60.dp)
        )

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .size(190.dp)
                .clip(CircleShape)
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                )
                .padding(35.dp)
        )

        Spacer(
            modifier = Modifier.height(70.dp)
        )

        FilaPerfil(
            etiqueta = "Nombre:",
            valor = "David Alejandro Berganza Monterroso"
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        FilaPerfil(
            etiqueta = "Carné:",
            valor = "25573"
        )

        Spacer(
            modifier = Modifier.height(70.dp)
        )

        OutlinedButton(
            onClick = onLogout,
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .height(55.dp)
        ) {

            Text(
                text = "Cerrar sesión",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun FilaPerfil(
    etiqueta: String,
    valor: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = etiqueta,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = valor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Perfil Preview"
)
@Composable
fun PantallaPerfilPreview() {

    MaterialTheme {

        PantallaPerfil(
            onLogout = {}
        )
    }
}