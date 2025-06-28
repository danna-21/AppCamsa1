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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.text.input.ImeAction


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
            }
        }
    }
}

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
            val focusManager = LocalFocusManager.current

            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next     // ① Botón “Next”
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }  // ② pasa al siguiente campo
                )
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done     // ③ Botón “Done”
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }  // ④ cierra el teclado
                )
            )
            Spacer(
                modifier = Modifier.height(35.dp)
            )
            Button(
                onClick = { },
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

            Text(
                text = "¿Olvidaste tu contraseña?",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFF9800),
                fontSize = 12.sp,
                modifier = Modifier.clickable {})
        }
    }
}


@Composable
fun PantallaRegistrarse(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current


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

            // Campos de texto
            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })

            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            TextField(
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
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
            )

            // Checkbox de Términos y Condiciones
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

            // Botón Registrar
            Button(
                onClick = { /* Aquí podrías validar y enviar datos */ },
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


@Preview(showBackground = true)
@Composable
fun PreviewPantallaLogin() {
    // 1) Creamos un navController de juguete
    val navController = rememberNavController()
    // 2) Llamamos tu Composable real
    PantallaLogin(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaRegistro() {
    val navController = rememberNavController()
    PantallaRegistrarse(navController)
}


@Composable
fun PantallaInicio(
    navController:
    NavController,
    nombreUsuario: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            BarraSuperior(nombreUsuario)
            ContenidoPrincipal()
            Especialidades()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio() {
    PantallaInicio(
        navController = rememberNavController(),
        nombreUsuario = "Danna"
    )
}


@Composable
fun BotonesPrincipales() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonPrincipal(icon = Icons.Default.LocalHospital, texto = "Enfermería")
            BotonPrincipal(icon = Icons.Default.Receipt, texto = "Recetas")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonPrincipal(icon = Icons.Default.DateRange, texto = "Calendario")
            BotonPrincipal(icon = Icons.Default.Biotech, texto = "Laboratorio")
        }
    }
}

@Composable
fun BotonPrincipal(icon: ImageVector, texto: String) {
    Button(
        onClick = { /* ... */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
        shape = RoundedCornerShape(6.dp),        // <-- aquí ajustas el radio
        modifier = Modifier.size(width = 152.dp, height = 38.dp)
    ) {
        Icon(icon, contentDescription = texto, tint = Color.White)
        Spacer(Modifier.width(8.dp))
        Text(texto, color = Color.White)
    }
}

@Composable
fun ContenidoPrincipal(nombreUsuario: String = "Danna") {
    Column {
        BotonesPrincipales()
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


//klk mi viejjito loco


//prueba de agregar a repositorio 2