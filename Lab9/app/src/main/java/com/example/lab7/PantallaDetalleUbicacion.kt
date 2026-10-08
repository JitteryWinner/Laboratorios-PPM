package com.example.lab7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalleUbicacion(
    location: Location,
    onBackClick: () -> Unit
) {

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text("Detalles de ubicacion")
                },
                navigationIcon = {

                    IconButton(
                        onClick = onBackClick
                    ) {

                        Icon(
                            imageVector =
                                Icons.AutoMirrored.Filled.ArrowBack,

                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer,

                    titleContentColor =
                        MaterialTheme.colorScheme.onPrimaryContainer,

                    navigationIconContentColor =
                        MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Text(
                text = location.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(45.dp)
            )

            FilaDetalleUbicacion(
                etiqueta = "ID:",
                valor = location.id.toString()
            )

            FilaDetalleUbicacion(
                etiqueta = "Tipo:",
                valor = location.type
            )

            FilaDetalleUbicacion(
                etiqueta = "Dimension:",
                valor = location.dimension
            )
        }
    }
}

@Composable
fun FilaDetalleUbicacion(
    etiqueta: String,
    valor: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = etiqueta,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = valor,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Detalle Ubicacion Preview"
)
@Composable
fun PantallaDetalleUbicacionPreview() {

    val ubicacionEjemplo = Location(
        id = 1,
        name = "Tierra (C-137)",
        type = "Planeta",
        dimension = "Dimension C-137"
    )

    MaterialTheme {

        PantallaDetalleUbicacion(
            location = ubicacionEjemplo,
            onBackClick = {}
        )
    }
}