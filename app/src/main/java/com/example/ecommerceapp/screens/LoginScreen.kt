package com.example.ecommerceapp.screens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerceapp.LoginViewModel
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.ButtonComponent
import com.example.ecommerceapp.components.ClickableLoginTextComponent
import com.example.ecommerceapp.components.DividerTextComponent
import com.example.ecommerceapp.components.HeadingTextComponent
import com.example.ecommerceapp.components.MyTextField
import com.example.ecommerceapp.components.NormalTextComponent
import com.example.ecommerceapp.components.PasswordTextField
import com.example.ecommerceapp.components.UnderLinedTextComponent
import com.example.ecommerceapp.data.LoginUIEvent
import com.example.ecommerceapp.data.SignupUIEvent
import com.example.ecommerceapp.navigation.PostOfficeAppRouter
import com.example.ecommerceapp.navigation.Screen
import com.example.ecommerceapp.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .background(Color.White),
        ){
            Column (modifier = Modifier
                .fillMaxSize()) {
                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(10.dp))
                MyTextField(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                PasswordTextField(

                    labelValue = stringResource(id = R.string.password),

                    painterResource = painterResource(id = R.drawable.password),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                    )

                Spacer(modifier = Modifier.height(18.dp))
                UnderLinedTextComponent(value = stringResource(id = R.string.forget_password))
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    }, isEnabled = loginViewModel.allValidationsPassed.value )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false,onTextSelected ={
                    PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                } )
            }

        }
        if(loginViewModel.loginInProgress.value){
            CircularProgressIndicator()
        }

    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}