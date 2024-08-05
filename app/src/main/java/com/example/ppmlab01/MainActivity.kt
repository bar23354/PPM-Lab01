//Programación de Plataformas Móviles - sección 40
//Laboratorio #1
//Roberto Barreda #23354

package com.example.ppmlab01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ppmlab01.ui.theme.PPMLab01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPMLab01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(20.dp)
                    ) {
                        Bienvenida(
                            name = "Roberto",
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                        NombresPerro(
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                        BotonAdoptar()
                    }
                }
            }
        }
    }
}
//texto 1
@Composable
fun Bienvenida(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola, $name!",
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.primary)
    )
}

//texto en "conjunto"
@Composable
fun NombresPerro(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Posibles candidatos a adoptar:",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("1. Mancha")
        Text("2. Fresca")
        Text("3. Cooper")
    }
}

//boton
@Composable
fun BotonAdoptar() {
    val adoptMessage = remember { mutableStateOf("") }
    Button(
        onClick = {
            adoptMessage.value = "Porque nosotros dijimos: ¡Has adoptado a Mancha!"
            Log.d("Adoption", adoptMessage.value)
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Text("Adoptar")
    }
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = adoptMessage.value,
        style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PPMLab01Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Bienvenida("Roberto")
            NombresPerro()
            BotonAdoptar()
        }
    }
}
