package com.example.appcamsa1.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
import com.example.appcamsa1.R

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
                    imeAction = ImeAction.Next     // ① Botón "Next"
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
                    imeAction = ImeAction.Done     // ③ Botón "Done"
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }  // ④ cierra el teclado
                )
            )
            Spacer(
                modifier = Modifier.height(35.dp)
            )
            Button(
                onClick = { navController.navigate("inicio") },
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

@Preview(showBackground = true)
@Composable
fun PreviewPantallaLogin() {
    val navController = rememberNavController()
    PantallaLogin(navController)
}
