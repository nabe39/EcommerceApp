package com.example.ecommerceapp.screens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.ButtonComponent
import com.example.ecommerceapp.components.ClickableLoginTextComponent
import com.example.ecommerceapp.components.DividerTextComponent
import com.example.ecommerceapp.components.HeadingTextComponent
import com.example.ecommerceapp.components.MyTextField
import com.example.ecommerceapp.components.NormalTextComponent
import com.example.ecommerceapp.components.PasswordTextField
import com.example.ecommerceapp.components.UnderLinedTextComponent
import com.example.ecommerceapp.navigation.PostOfficeAppRouter
import com.example.ecommerceapp.navigation.Screen
import com.example.ecommerceapp.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(){
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
                onTextSelected = {

                }
            )
            PasswordTextField(
// <<<<<<< DungWork
                labelValue = stringResource(id = R.string.password),
// =======
//                 labelValue = stringResource(id = R.string.password), 
// >>>>>>> main
                painterResource = painterResource(id = R.drawable.password),
                onTextSelected = {

                })

            Spacer(modifier = Modifier.height(18.dp))
            UnderLinedTextComponent(value = stringResource(id = R.string.forget_password))
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked = {})
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = false,onTextSelected ={
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            } )
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