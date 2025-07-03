package com.example.appcamsa1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcamsa1.presentation.login.PantallaLogin
import com.example.appcamsa1.presentation.signup.PantallaRegistrarse
import com.example.appcamsa1.presentation.index.PantallaInicio
import com.example.appcamsa1.presentation.initial.PantallaEnfermeria

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
                    PantallaInicio(navController, nombreUsuario = "Joseph")
                }
                composable("enfermeria") {
                    PantallaEnfermeria(navController)
                }
            }
        }
    }
}