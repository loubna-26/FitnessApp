package com.loubna.fitnessapp.ui.theme.screen

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loubna.fitnessapp.ui.theme.FitnessAppTheme
import com.loubna.fitnessapp.ui.theme.FondoPantalla
import com.loubna.fitnessapp.ui.theme.GrisOscuro
import com.loubna.fitnessapp.ui.theme.VerdeDeporte
import com.loubna.fitnessapp.ui.theme.components.CalendariPicker
import com.loubna.fitnessapp.ui.theme.components.DropdownTextField
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

// Screen to edit profile
@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    pes: Double,
    alcada: Int,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, String, String, Int, Double, String, String) -> Unit
) {
    var nomNou by remember { mutableStateOf(nom) }
    var emailNou by remember { mutableStateOf(email) }
    var dataNaixementNou by remember { mutableStateOf(dataNaixement) }
    var genereNou by remember { mutableStateOf(genere) }
    var alcadaNou by remember { mutableStateOf(alcada.toString()) }
    var pesNou by remember { mutableStateOf(pes.toString()) }
    var objectiuPesNou by remember { mutableStateOf("55") }
    var objectiuNou by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou by remember { mutableStateOf(nivellActivitat) }
    var fotoUri by remember { mutableStateOf<Uri?>(null) }

    val opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")
    val opcionsObjectiu = listOf("Guanyar massa muscular", "Perdre pes", "Mantenir-se en forma")
    val opcionsNivell = listOf("Sedentari", "Lleuger", "Moderat", "Actiu", "Molt actiu")

    val context = LocalContext.current
    val launcherFoto =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) fotoUri = uri
        }

    val fotoBitmap = remember(fotoUri) {
        fotoUri?.let { uri ->
            context.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPantalla)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Editar de perfil",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        Text(
            text = "Foto de perfil",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (fotoBitmap != null) {
                Image(
                    bitmap = fotoBitmap.asImageBitmap(),
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(VerdeDeporte),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Sense foto",
                        modifier = Modifier.size(60.dp),
                        tint = FondoPantalla
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {
                        launcherFoto.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeDeporte)
                ) {
                    Text("Canviar foto", color = Color.White)
                }
                OutlinedButton(onClick = { fotoUri = null }) {
                    Text("Eliminar foto", color = GrisOscuro)
                }
            }
        }

        Text(
            text = "Dades personals",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Correu electrònic") },
            modifier = Modifier.fillMaxWidth()
        )

        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = textAMillis(dataNaixementNou),
            onDateSelected = { dataNaixementNou = millisAText(it) },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownTextField(
            label = "Gènere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier.fillMaxWidth()
        )

        // Dades físiques
        Text(
            text = "Dades físiques",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = alcadaNou,
                onValueChange = { alcadaNou = it },
                label = { Text("Alçada (cm)") },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = pesNou,
                onValueChange = { pesNou = it },
                label = { Text("Pes (kg)") },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = objectiuPesNou,
                onValueChange = { objectiuPesNou = it },
                label = { Text("Objectiu de pes (kg)") },
                modifier = Modifier.weight(1f)
            )
        }

        // Objectiu principal
        Text(
            text = "Objectiu principal",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        DropdownTextField(
            label = "Objectiu principal",
            opcions = opcionsObjectiu,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier.fillMaxWidth()
        )

        // Nivell d'activitat
        Text(
            text = "Nivell d'activitat",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )

        DropdownTextField(
            label = "Nivell d'activitat",
            opcions = opcionsNivell,
            valorSeleccionat = nivellActivitatNou,
            onValorSeleccionat = { nivellActivitatNou = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                guardar(
                    nomNou,
                    emailNou,
                    dataNaixementNou,
                    genereNou,
                    alcadaNou.toIntOrNull() ?: alcada,
                    pesNou.replace(',', '.').toDoubleOrNull() ?: pes,
                    objectiuNou,
                    nivellActivitatNou
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = VerdeDeporte)
        ) {
            Text(text = "Guardar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    FitnessAppTheme {
        EditProfileScreen(
            nom = "Laia Soler",
            email = "laia.soler@exemple.com",
            dataNaixement = "14/05/1999",
            genere = "Femení",
            pes = 60.0,
            alcada = 165,
            objectiu = "Guanyar massa muscular",
            nivellActivitat = "Moderat",
            guardar = { _, _, _, _, _, _, _, _ -> })
    }
}

private fun textAMillis(text: String): Long? {
    return try {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        formatter.parse(text)?.time
    } catch (e: Exception) {
        null
    }
}

private fun millisAText(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.format(Date(millis))
}