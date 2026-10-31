package com.loubna.fitnessapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loubna.fitnessapp.R
import com.loubna.fitnessapp.ui.theme.FitnessAppTheme
import com.loubna.fitnessapp.ui.theme.FondoPantalla
import com.loubna.fitnessapp.ui.theme.GrisOscuro
import com.loubna.fitnessapp.ui.theme.NaranjaEnergia
import com.loubna.fitnessapp.ui.theme.VerdeClaro
import com.loubna.fitnessapp.ui.theme.VerdeDeporte
import java.util.Calendar

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    pes: Double,
    alcada: Int,
    objectiu: String,
    nivellActivitat: String,
    editar: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPantalla)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Bar: Título y Editar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Perfil",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = GrisOscuro
            )
            Image(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "Editar perfil",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .clickable { editar() }
            )
        }

        // Header: Foto, Nom y Email
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .background(VerdeDeporte),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Sense foto",
                    modifier = Modifier.size(64.dp),
                    tint = FondoPantalla
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = nom,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = GrisOscuro
            )
            Text(
                text = email,
                fontSize = 15.sp,
                color = GrisOscuro.copy(alpha = 0.7f)
            )
        }

        // Card de Dades Físiques
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = VerdeClaro)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null,
                        tint = VerdeDeporte,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        "Edat",
                        fontSize = 13.sp,
                        color = GrisOscuro.copy(alpha = 0.7f)
                    )
                    val edat = try {
                        Calendar.getInstance().get(Calendar.YEAR) - dataNaixement.substring(6).toInt()
                    } catch (e: Exception) {
                        25
                    }
                    Text(
                        edat.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrisOscuro
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_gender),
                        contentDescription = null,
                        tint = VerdeDeporte,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        "Gènere",
                        fontSize = 13.sp,
                        color = GrisOscuro.copy(alpha = 0.7f)
                    )
                    Text(
                        genere,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrisOscuro
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_height),
                        contentDescription = null,
                        tint = VerdeDeporte,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        "Alçada",
                        fontSize = 13.sp,
                        color = GrisOscuro.copy(alpha = 0.7f)
                    )
                    Text(
                        "$alcada cm",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrisOscuro
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pes),
                        contentDescription = null,
                        tint = VerdeDeporte,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        "Pes",
                        fontSize = 13.sp,
                        color = GrisOscuro.copy(alpha = 0.7f)
                    )
                    Text(
                        "$pes kg",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrisOscuro
                    )
                }
            }
        }

        // Secció Objectius
        Text(
            text = "Objectius",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = VerdeClaro)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_objectiu),
                    contentDescription = null,
                    tint = NaranjaEnergia,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = objectiu,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrisOscuro
                )
            }
        }

        // Secció Nivell d'activitat
        Text(
            text = "Nivell d'activitat",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = GrisOscuro
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = VerdeClaro)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_activitat),
                    contentDescription = null,
                    tint = NaranjaEnergia,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = nivellActivitat,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = GrisOscuro
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    FitnessAppTheme {
        ProfileScreen(
            nom = "Laia Soler",
            email = "laia.soler@gmail.com",
            dataNaixement = "16/10/1999",
            genere = "Femení",
            pes = 55.5,
            alcada = 160,
            objectiu = "Guanyar massa muscular",
            nivellActivitat = "Moderat",
            editar = {}
        )
    }
}