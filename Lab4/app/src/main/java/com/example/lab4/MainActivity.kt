package com.example.lab4
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    CaratulaUVG()
                }
            }
        }
    }
}

@Composable
fun CaratulaUVG() {

    val verdeUVG = Color(0xFF146B2E)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
            .border(
                width = 3.dp,
                color = verdeUVG
            )
    ) {

        // ESCUDO UVG DE FONDO
        Image(
            painter = painterResource(id = R.drawable.escudo_uvg),
            contentDescription = "Escudo Universidad del Valle",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(230.dp)
                .align(Alignment.Center)
                .alpha(0.10f)
        )

        // CONTENIDO
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // TITULO
            Text(
                text = "Universidad del Valle\nde Guatemala",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 29.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(18.dp))

            // CURSO
            Text(
                text = "Programación de plataformas\nmóviles, Sección 30",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                lineHeight = 23.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            // INTEGRANTES
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.Top
            ) {

                Text(
                    text = "    INTEGRANTES",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    color = Color.Black
                )

                Text(
                    text = "David Berganza\nWilfred Orellana\nJorge Morales",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1.4f),
                    color = Color.Black,
                    lineHeight = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // CATEDRATICO
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "    CATEDRÁTICO",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    color = Color.Black
                )

                Text(
                    text = "Juan Carlos Durini",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1.4f),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // DATOS DEL ALUMNO
            Text(
                text = "David Berganza\n25573",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CaratulaPreview() {
    MaterialTheme {
        CaratulaUVG()
    }
}