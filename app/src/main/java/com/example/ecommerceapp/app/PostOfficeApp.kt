package com.example.ecommerceapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ecommerceapp.navigation.PostOfficeAppRouter
import com.example.ecommerceapp.navigation.Screen
import com.example.ecommerceapp.screens.LoginScreen
import com.example.ecommerceapp.screens.SignUpScreen
import com.example.ecommerceapp.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()
                }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
            }
        }
    }
}