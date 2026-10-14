package com.example.lab7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detalles(
    character: Character,
    onBackClick: () -> Unit
) {

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text("Detalles de Personaje")
                },
                navigationIcon = {

                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
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
                modifier = Modifier.height(20.dp)
            )

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp)
                    .clip(CircleShape)
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = character.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(35.dp)
            )

            DetailRow(
                label = "Especie:",
                value = character.species
            )

            DetailRow(
                label = "Estado:",
                value = character.status
            )

            DetailRow(
                label = "Genero:",
                value = character.gender
            )
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Detalle Personaje Preview"
)
@Composable
fun DetallesPreview() {

    val personajeEjemplo = Character(
        id = 1,
        name = "Rick Sanchez (C-137)",
        status = "Vivo",
        species = "Humano",
        gender = "Hombre",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    )

    MaterialTheme {

        Detalles(
            character = personajeEjemplo,
            onBackClick = {}
        )
    }
}