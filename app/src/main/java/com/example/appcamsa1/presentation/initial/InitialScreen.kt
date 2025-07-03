package com.example.appcamsa1.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appcamsa1.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.DeviceThermostat
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEnfermeria(navController: NavController) {
    var peso by remember { mutableStateOf("0") }
    var estatura by remember { mutableStateOf("0") }
    var temperatura by remember { mutableStateOf("0") }
    var frecuenciaCardiaca by remember { mutableStateOf("0") }
    var frecuenciaRespiratoria by remember { mutableStateOf("0") }
    var glucosa by remember { mutableStateOf("0") }
    var colesterol by remember { mutableStateOf("0") }
    var urea by remember { mutableStateOf("0") }
    var trigliceridos by remember { mutableStateOf("0") }
    var saturacionOxigeno by remember { mutableStateOf("0") }
    var creatinina by remember { mutableStateOf("0") }
    var presionArterial by remember { mutableStateOf("0") }
    var hemoglobina by remember { mutableStateOf("0") }

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopAppBar(
            title = { Text("Enfermería", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0097A7))
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            CampoEnfermeria(Icons.Default.MonitorWeight, "Peso", peso) { peso = it }
            CampoEnfermeria(Icons.Default.Straighten, "Estatura", estatura) { estatura = it }
            CampoEnfermeria(Icons.Default.DeviceThermostat, "Temperatura", temperatura) { temperatura = it }
            CampoEnfermeria(Icons.Default.Favorite, "Frecuencia Cardíaca", frecuenciaCardiaca) { frecuenciaCardiaca = it }
            CampoEnfermeria(Icons.Default.Air, "Frecuencia Respiratoria", frecuenciaRespiratoria) { frecuenciaRespiratoria = it }
            CampoEnfermeria(Icons.Default.Bloodtype, "Glucosa", glucosa) { glucosa = it }
            CampoEnfermeria(Icons.Default.Fastfood, "Colesterol", colesterol) { colesterol = it }
            CampoEnfermeria(Icons.Default.Healing, "Urea", urea) { urea = it }
            CampoEnfermeria(Icons.Default.LocalFireDepartment, "Triglicéridos", trigliceridos) { trigliceridos = it }
            CampoEnfermeria(Icons.Default.BubbleChart, "Saturación de Oxígeno", saturacionOxigeno) { saturacionOxigeno = it }
            CampoEnfermeria(Icons.Default.MedicalServices, "Creatinina", creatinina) { creatinina = it }
            CampoEnfermeria(Icons.Default.FavoriteBorder, "Presión Arterial", presionArterial) { presionArterial = it }
            CampoEnfermeria(Icons.Default.Opacity, "Hemoglobina", hemoglobina) { hemoglobina = it }
        }
    }
}

@Composable
fun CampoEnfermeria(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}
