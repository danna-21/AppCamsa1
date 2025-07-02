package com.example.appcamsa1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.DeviceThermostat
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController, startDestination = "login"
            ) {
                composable("login") {
                    PantallaLogin(navController)
                }
                composable("registro") {
                    PantallaRegistrarse(navController)
                }
                composable("inicio") {
                    PantallaInicio(navController, nombreUsuario = "Danna")
                }
                composable("enfermeria") {
                    PantallaEnfermeria(navController)
                }
            }
        }
    }
}

// PANTALLA 1: login
@Composable
fun PantallaLogin(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logomaily),
                contentDescription = "Logo Maily T-Cuida",
                modifier = Modifier.size(110.dp),
            )
            Spacer(
                modifier = Modifier.height(3.dp)
            )
            Text(
                text = "Maily", fontSize = 35.sp, fontWeight = FontWeight.Normal
            )
            Text(
                text = "T-Cuida", fontSize = 18.sp, fontWeight = FontWeight.Normal
            )
            Spacer(
                modifier = Modifier.height(120.dp)
            )
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val focusManager = LocalFocusManager.current //permite mover el foco de un campo a otro



            TextField( //CAMPO TEXTO: correo
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Correo electrónico", fontSize = 14.sp, color = Color.Gray) },
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )

            TextField( //CAMPO TEXTO: contraseña
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Contraseña", fontSize = 14.sp, color = Color.Gray) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )
            Spacer(
                modifier = Modifier.height(35.dp)
            )
            // boton iniciar sesion
            Button(
                onClick = { navController.navigate("inicio") }, // redirije a pantalla inicio
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)), // Naranja
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Iniciar sesión",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 21.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(5.dp)
            )
            // boton registrarse
            Button(
                onClick = { navController.navigate("registro") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    "Registrarse",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(5.dp)
            )
            // boton olvidaste tu contraseña
            Text(
                text = "¿Olvidaste tu contraseña?",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFF9800),
                fontSize = 12.sp,
                modifier = Modifier.clickable {})
        }
    }
}

// PANTALLA 2: registro
@Composable
fun PantallaRegistrarse(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current //permite mover el foco de un campo a otro


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logomaily),
                contentDescription = "Logo Maily T-Cuida",
                modifier = Modifier.size(110.dp),

                )
            Spacer(
                modifier = Modifier.height(3.dp)
            )
            Text(
                text = "Maily", fontSize = 35.sp, fontWeight = FontWeight.Normal
            )
            Text(
                text = "T-Cuida", fontSize = 18.sp, fontWeight = FontWeight.Normal
            )
            Spacer(
                modifier = Modifier.height(70.dp)
            )

            TextField( //CAMPO DE TEXTO: nombre
                value = nombre,
                onValueChange = { nombre = it },
                placeholder = {
                    Text(
                        "Nombre (s)", fontSize = 14.sp, color = Color.Gray
                    )
                },
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField( //CAMPO DE TEXTO: apellidos
                value = apellidos,
                onValueChange = { apellidos = it },
                placeholder = {
                    Text(
                        "Apellidos", fontSize = 14.sp, color = Color.Gray
                    )
                },
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField( //CAMPO DE TEXTO: correo
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        "Correo electrónico", fontSize = 14.sp, color = Color.Gray
                    )
                },
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField( //CAMPO DE TEXTO: contraseña
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        "Contraseña", fontSize = 14.sp, color = Color.Gray
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedTextColor = Color.Gray,
                    unfocusedTextColor = Color.Gray
                ),
                // propiedades que hacen que al dar enter se pase al sig. campo de texto
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
            )

            // checkbox de términos y condiciones
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 19.dp)
            ) {
                Checkbox(
                    checked = aceptaTerminos,
                    onCheckedChange = { aceptaTerminos = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFFF9800)
                    )
                )
                Text(
                    "Acepto los Términos y Condiciones de Maily.", fontSize = 12.sp
                )
            }
            Spacer(Modifier.height(24.dp))

            // boton registrar
            Button(
                onClick = { navController.navigate("inicio") }, // redirije a pantalla inicio
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    "Registrarse",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 21.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(5.dp)
            )
            Text(
                text = "¿Ya tienes una cuenta?",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFF9800),
                fontSize = 12.sp,
                modifier = Modifier.clickable { navController.popBackStack() })
        }
    }
}

// muestra preview de pantalla login
@Preview(showBackground = true)
@Composable
fun PreviewPantallaLogin() {
    // 1) Creamos un navController de juguete
    val navController = rememberNavController()
    // 2) Llamamos tu Composable real
    PantallaLogin(navController)
}

// muestra preview de pantalla regisro
@Preview(showBackground = true)
@Composable
fun PreviewPantallaRegistro() {
    val navController = rememberNavController()
    PantallaRegistrarse(navController)
}

// PANTALLA 3: inicio
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
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            BarraSuperior(nombreUsuario)
            ContenidoPrincipal(navController, nombreUsuario)
        }
    }
}

// se muestra la nav bar
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
        // parte izquierda: logo + textos
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logomaily),
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

        // parte derecha: iconos carrito y menú
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio() {
    PantallaInicio(
        navController = rememberNavController(),
        nombreUsuario = "Danna"
    )
}

// botones enfermeria, recetas, calendario y lab
@Composable
fun BotonesPrincipales(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            BotonPrincipal(
                icon = Icons.Default.LocalHospital,
                texto = "Enfermería",
                onClick = { navController.navigate("enfermeria") }
            )
            BotonPrincipal(
                icon = Icons.Default.Receipt,
                texto = "Recetas",
                onClick = { /* luego lo conectas */ }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            BotonPrincipal(
                icon = Icons.Default.DateRange,
                texto = "Calendario",
                onClick = { /* luego lo conectas */ }
            )
            BotonPrincipal(
                icon = Icons.Default.Biotech,
                texto = "Laboratorio",
                onClick = { /* luego lo conectas */ }
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
        modifier = Modifier.size(width = 156.dp, height = 38.dp)
    ) {
        Icon(icon, contentDescription = texto, tint = Color.White)
        Spacer(Modifier.width(5.dp))
        Text(texto, color = Color.White)
    }
}

@Composable
fun ContenidoPrincipal(navController: NavController, nombreUsuario: String = "Danna") {
    Column {
        BotonesPrincipales(navController)
        Especialidades()
        SeccionBlog()
    }
}

// botones especialidades
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
        modifier = Modifier.size(width = 160.dp, height = 38.dp)
    ) {
        Text(text = texto, color = Color.Black, fontSize = 13.sp)
    }
}

// blog
@Composable
fun SeccionBlog() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Blog",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Artículo 1: Ansiedad
        Text(
            text = "¿Qué hacer cuando una persona tiene un ataque de ansiedad?",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = R.drawable.depresion),
            contentDescription = "Imagen depresion",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
        Text(
            text = "Un ataque de ansiedad puede ser muy abrumador. Es importante mantener la calma, acompañar a la persona, hablar con voz suave y ayudarla a respirar profundamente...",
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Artículo 2: Depresión
        Text(
            text = "¿Qué hacer cuando una persona sufre depresión?",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Text(
            text = "La depresión requiere apoyo emocional, comprensión y en muchos casos ayuda profesional. Evita juzgar, escucha activamente y acompaña a la persona en su proceso...",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Image(
            painter = painterResource(id = R.drawable.ansiedad),
            contentDescription = "Imagen ansiedad",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
    }
}

@Composable
fun CampoEnfermeria(
    icono: ImageVector,
    etiqueta: String,
    valor: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icono,
            contentDescription = etiqueta,
            tint = Color(0xFF009688),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = etiqueta, modifier = Modifier.weight(1f), color = Color.Black)
        TextField(
            value = valor,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.width(60.dp)
        )
    }
}

// PANTALLA 4: pantalla enfermeria
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEnfermeria(navController: NavController) {
    // Estados para cada campo
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
        // Barra superior
        TopAppBar(
            title = { Text("Enfermería", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0097A7))
        )

        // Contenido scrollable
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)) {

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaEnfermeria() {
    // Para la preview usamos un NavController "falso"
    val navController = rememberNavController()
    PantallaEnfermeria(navController)
}
