package com.example.appcamsa1.presentation.index

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcamsa1.R
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun PantallaInicio(
    navController: NavController,
    nombreUsuario: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            // Barra de color para el status bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color(0xFF2596be))
            )
            Column {
                BarraSuperior(nombreUsuario)
                ContenidoPrincipal(navController)
                Especialidades()
            }
        }
    }
}

@Composable
fun BarraSuperior(nombreUsuario: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2596be)) // Color HEX #2596be
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Parte izquierda: logo + textos
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logomaily), // Asegúrate de tener el logo en res/drawable
                contentDescription = "Logo",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Hola, $nombreUsuario",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = "Registra tu estado de salud hoy.",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
        // Parte derecha: iconos carrito y menú
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /* Acción del carrito */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.iconocarrito),
                    contentDescription = "Carrito",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* Aquí luego desplegamos el menú */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.iconomenu),
                    contentDescription = "Menú",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun BotonesPrincipales(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonPrincipal(
                icon = Icons.Default.LocalHospital,
                texto = "Enfermería",
                onClick = { navController.navigate("enfermeria") }
            )
            BotonPrincipal(
                icon = Icons.Default.Receipt,
                texto = "Recetas",
                onClick = { /* Aquí puedes poner la navegación a Recetas si la tienes */ }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonPrincipal(
                icon = Icons.Default.DateRange,
                texto = "Calendario",
                onClick = { /* Aquí puedes poner la navegación a Calendario si la tienes */ }
            )
            BotonPrincipal(
                icon = Icons.Default.Biotech,
                texto = "Laboratorio",
                onClick = { /* Aquí puedes poner la navegación a Laboratorio si la tienes */ }
            )
        }
    }
}

@Composable
fun BotonPrincipal(icon: ImageVector, texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.size(width = 152.dp, height = 38.dp)
    ) {
        Icon(icon, contentDescription = texto, tint = Color.White)
        Spacer(Modifier.width(8.dp))
        Text(texto, color = Color.White)
    }
}

@Composable
fun ContenidoPrincipal(navController: NavController, nombreUsuario: String = "Danna") {
    Column {
        BotonesPrincipales(navController)
        // Luego agregamos el resto
    }
}

@Composable
fun Especialidades() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Descubre a nuestros especialistas",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Filas de botones
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonEspecialidad("Nutrición", modifier = Modifier.weight(1f))
            BotonEspecialidad("Psicología", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonEspecialidad("Odontología", modifier = Modifier.weight(1f))
            BotonEspecialidad("Fisioterapia", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonEspecialidad("Dermacosmética", modifier = Modifier.weight(1f))
            BotonEspecialidad("Especialidades", modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun BotonEspecialidad(texto: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Acción futura */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.size(width = 155.dp, height = 38.dp)
    ) {
        Text(text = texto, color = Color.Black, fontSize = 14.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio() {
    PantallaInicio(
        navController = rememberNavController(),
        nombreUsuario = "Danna"
    )
}
