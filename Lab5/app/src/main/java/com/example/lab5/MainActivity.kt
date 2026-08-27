package com.example.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab5Theme {
                PantallaRestaurante()
            }
        }
    }
}

@Composable
fun PantallaRestaurante() {

    val context = LocalContext.current

    val colorCelesteFondo = Color(0xFFDDF3FA)
    val colorCelesteTexto = Color(0xFF18A7DC)
    val colorNaranja = Color(0xFFF67A57)
    val colorMoradoClaro = Color(0xFF8954F7)
    val colorMoradoIcono = Color(0xFF7629F5)

    val colorCard = if (isSystemInDarkTheme()) {
        MaterialTheme.colorScheme.surface
    } else {
        Color.White
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorCelesteFondo)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_refresh
                    ),
                    contentDescription = "Actualizar",
                    tint = colorCelesteTexto,
                    modifier = Modifier.size(30.dp)
                )

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Text(
                    text = "Actualización disponible",
                    color = colorCelesteTexto,
                    fontSize = 17.sp,
                    modifier = Modifier.weight(1f)
                )

                TextButton(
                    onClick = {

                        val linkPlayStore =
                            "https://play.google.com/store/apps/details?id=com.whatsapp"

                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(linkPlayStore)
                        )

                        context.startActivity(intent)
                    }
                ) {

                    Text(
                        text = "Descargar",
                        color = colorCelesteTexto
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Sábado",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = "28 de marzo",
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                OutlinedButton(
                    onClick = {

                        Toast.makeText(
                            context,
                            "Jornada terminada",
                            Toast.LENGTH_SHORT
                        ).show()

                    },
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(
                        1.dp,
                        Color(0xFFBDBDBD)
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorMoradoClaro
                    )
                ) {

                    Text(
                        text = "Terminar jornada"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorCard
                )
            ) {

                Column(
                    modifier = Modifier.padding(
                        top = 18.dp,
                        bottom = 16.dp
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Tre Fratelli",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(
                            onClick = {

                                val linkMaps =
                                    "https://maps.app.goo.gl/d1z66pS45nCmKGo66"

                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(linkMaps)
                                )

                                context.startActivity(intent)
                            }
                        ) {

                            Icon(
                                painter = painterResource(
                                    id = R.drawable.ic_directions
                                ),
                                contentDescription = "Direcciones",
                                tint = colorMoradoIcono,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Plaza Los Manantiales, San Cristóbal",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        modifier = Modifier.padding(
                            start = 18.dp,
                            end = 8.dp
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "7:00 AM - 11:00 PM",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(
                            start = 18.dp
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button(
                            onClick = {

                                Toast.makeText(
                                    context,
                                    "David Alejandro Berganza Monterroso",
                                    Toast.LENGTH_SHORT
                                ).show()

                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorNaranja,
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                text = "Iniciar",
                                fontSize = 17.sp
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(30.dp)
                        )

                        TextButton(
                            onClick = {

                                Toast.makeText(
                                    context,
                                    "Comida italiana\nQQ",
                                    Toast.LENGTH_LONG
                                ).show()

                            },
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Detalles",
                                color = colorNaranja,
                                fontSize = 17.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PantallaRestaurantePreview() {

    Lab5Theme {
        PantallaRestaurante()
    }
}