package com.example.ppmlab01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ppmlab01.ui.theme.PPMLab01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPMLab01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bienvenida(
                        name = "Roberto",
                        modifier = Modifier.padding(innerPadding)
                    )
                    NombresPerro(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Bienvenida(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

@Composable
fun NombresPerro(modifier: Modifier = Modifier) {
    Column(modifier= modifier) {
        Text("")
        Text("Posibles candidatos a adoptar:")
        Text("1. Mancha")
        Text("2. Fresca")
        Text("3. Cooper")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PPMLab01Theme {
        Column {
            Bienvenida("Roberto")
            NombresPerro()
        }
    }
}