package com.example.ecommerceapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.HeadingTextComponent
import com.example.ecommerceapp.navigation.PostOfficeAppRouter
import com.example.ecommerceapp.navigation.Screen
import com.example.ecommerceapp.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .padding(16.dp)) {
        HeadingTextComponent(value = stringResource(id = R.string.term_and_contract_header))
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun TermsScreenPreview(){
    TermsAndConditionsScreen()
}