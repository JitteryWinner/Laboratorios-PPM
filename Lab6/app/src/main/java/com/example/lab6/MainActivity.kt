package com.example.lab6
import android.os.Bundle
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Movimiento(
    val valor: Int,
    val incremento: Boolean
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PantallaContador()
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PantallaContador() {

// Estados

    var contador by remember {
        mutableIntStateOf(0)
    }

    val historial = remember {
        mutableStateListOf<Movimiento>()
    }

   // Estadisticas

    val totalIncrementos = historial.count {
        it.incremento
    }

    val totalDecrementos = historial.count {
        !it.incremento
    }

    val valorMaximo = historial.maxOfOrNull {
        it.valor
    } ?: 0

    val valorMinimo = historial.minOfOrNull {
        it.valor
    } ?: 0

    val totalCambios = historial.size

    // Colores
    val azul = Color(0xFF5661db)
    val verde = Color(0xFF32c752)
    val rojo = Color(0xFFd93425)

    Scaffold(

        //Boton de borrar historial
        bottomBar = {

            Button(
                onClick = {
                    contador = 0
                    historial.clear()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 20.dp,
                        top = 10.dp
                    )
                    .height(48.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = azul
                )
            ) {

                Text(
                    text = "Reiniciar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                bottom = 20.dp
            )
        ) {

// Titulo

            item {

                Text(
                    text = "David Alejandro Berganza Monterroso",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(
                    modifier = Modifier.height(32.dp)
                )
            }

// Contador

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Menos
                    Button(
                        onClick = {

                            contador--

                            historial.add(
                                Movimiento(
                                    valor = contador,
                                    incremento = false
                                )
                            )
                        },
                        modifier = Modifier.size(48.dp),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = azul
                        )
                    ) {

                        Text(
                            text = "−",
                            fontSize = 28.sp,
                            color = Color.White
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(24.dp)
                    )

                    // Numero
                    Text(
                        text = contador.toString(),
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(
                        modifier = Modifier.width(24.dp)
                    )

                    // Mas
                    Button(
                        onClick = {

                            contador++

                            historial.add(
                                Movimiento(
                                    valor = contador,
                                    incremento = true
                                )
                            )
                        },
                        modifier = Modifier.size(48.dp),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = azul
                        )
                    ) {

                        Text(
                            text = "+",
                            fontSize = 26.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                Divider()

                Spacer(
                    modifier = Modifier.height(18.dp)
                )
            }

   // Estadisticas

            item {

                Column(
                    modifier = Modifier.padding(
                        horizontal = 24.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    FilaEstadistica(
                        titulo = "Total incrementos:",
                        valor = totalIncrementos
                    )

                    FilaEstadistica(
                        titulo = "Total decrementos:",
                        valor = totalDecrementos
                    )

                    FilaEstadistica(
                        titulo = "Valor máximo:",
                        valor = valorMaximo
                    )

                    FilaEstadistica(
                        titulo = "Valor mínimo:",
                        valor = valorMinimo
                    )

                    FilaEstadistica(
                        titulo = "Total cambios:",
                        valor = totalCambios
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Historial:",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }
            }
// Historial

            item {

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),

                    // MÁXIMO 5 ELEMENTOS POR FILA
                    maxItemsInEachRow = 5,

                    horizontalArrangement =
                        Arrangement.spacedBy(12.dp),

                    verticalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    historial.forEach { movimiento ->

                        Box(
                            modifier = Modifier
                                .width(58.dp)
                                .height(48.dp)
                                .background(
                                    color = if (movimiento.incremento) {
                                        verde
                                    } else {
                                        rojo
                                    },
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = movimiento.valor.toString(),
                                color = Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier.height(30.dp)
                )
            }
        }
    }
}


// Componentes para las estadisticas

@Composable
fun FilaEstadistica(
    titulo: String,
    valor: Int
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = titulo,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = valor.toString(),
            fontSize = 20.sp
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewPantallaContador() {
    MaterialTheme {
        PantallaContador()
    }
}