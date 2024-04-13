package com.example.ecommerceapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.ButtonComponent
import com.example.ecommerceapp.components.HeadingTextComponent
import com.example.ecommerceapp.data.SignupViewModel

@Composable
fun HomeScreen(signupViewModel: SignupViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White),
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = stringResource(id = R.string.home))
            ButtonComponent(value = stringResource(id = R.string.logout),
                onButtonClicked = {
                    signupViewModel.logout()
            }, isEnabled = true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

}