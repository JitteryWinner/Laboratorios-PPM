package com.example.lab7

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PantallaLogin(
    onStartClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(
                id = R.drawable.rick_morty_logo
            ),
            contentDescription = "Rick and Morty Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onStartClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Empezar"
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "David Alejandro Berganza Monterroso 25573",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Login Preview"
)
@Composable
fun PantallaLoginPreview() {

    MaterialTheme {

        PantallaLogin(
            onStartClick = {}
        )
    }
}