package com.example.lab7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaUbicaciones(
    locations: List<Location>,
    onLocationClick: (Int) -> Unit
) {

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text("Ubicaciones")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer,

                    titleContentColor =
                        MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            items(
                items = locations,
                key = { location ->
                    location.id
                }
            ) { location ->

                ItemUbicacion(
                    location = location,
                    onClick = {
                        onLocationClick(location.id)
                    }
                )
            }
        }
    }
}

@Composable
fun ItemUbicacion(
    location: Location,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 20.dp,
                vertical = 20.dp
            )
    ) {

        Text(
            text = location.name,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = location.type,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    HorizontalDivider()
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Ubicaciones"
)
@Composable
fun PantallaUbicacionesPreview() {

    val ubicacionesEjemplo = listOf(
        Location(
            id = 1,
            name = "Tierra (C-137)",
            type = "Planeta",
            dimension = "Dimension C-137"
        ),
        Location(
            id = 2,
            name = "Abadango",
            type = "Cluster",
            dimension = "desconocida"
        ),
        Location(
            id = 3,
            name = "Ciudadela de los Ricks",
            type = "Estacion espacial",
            dimension = "desconocida"
        ),
        Location(
            id = 4,
            name = "La guarida de los Worldenders",
            type = "Planeta",
            dimension = "desconocida"
        )
    )

    MaterialTheme {

        PantallaUbicaciones(
            locations = ubicacionesEjemplo,
            onLocationClick = {}
        )
    }
}