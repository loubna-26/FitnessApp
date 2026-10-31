package com.loubna.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.loubna.fitnessapp.ui.theme.FitnessAppTheme
import com.loubna.fitnessapp.ui.theme.screen.EditProfileScreen
import com.loubna.fitnessapp.ui.theme.screen.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom: String by remember { mutableStateOf("Laia Soler") }
    var email: String by remember { mutableStateOf("Laia.Soler@gmail.com") }
    var dataNaixement: String by remember { mutableStateOf("16/10/1999") }
    var genere: String by remember { mutableStateOf("Dona") }
    var alcada: Int by remember { mutableStateOf(160) }
    var pes: Double by remember { mutableStateOf(55.5) }
    var objectiu: String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf("Moderat") }
    var editar: Boolean by remember { mutableStateOf(true) }

    if (editar) {
        EditProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            pes = pes,
            alcada = alcada,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            guardar = { nouNom, nouEmail, novaData, nouGenere, novaAlcada, nouPes, nouObjectiu, nouNivell ->
                nom = nouNom
                email = nouEmail
                dataNaixement = novaData
                genere = nouGenere
                alcada = novaAlcada
                pes = nouPes
                objectiu = nouObjectiu
                nivellActivitat = nouNivell
                editar = false
            }
        )
    } else {
        ProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            pes = pes,
            alcada = alcada,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
        ) { editar = true }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}
