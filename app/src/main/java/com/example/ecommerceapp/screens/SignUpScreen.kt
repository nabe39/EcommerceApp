package com.example.ecommerceapp.screens

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
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.ButtonComponent
import com.example.ecommerceapp.navigation.PostOfficeAppRouter
import com.example.ecommerceapp.navigation.Screen
import com.example.ecommerceapp.components.CheckboxComponent
import com.example.ecommerceapp.components.ClickableLoginTextComponent
import com.example.ecommerceapp.components.DividerTextComponent
import com.example.ecommerceapp.components.HeadingTextComponent
import com.example.ecommerceapp.components.MyTextField
import com.example.ecommerceapp.components.NormalTextComponent
import com.example.ecommerceapp.components.PasswordTextField
import com.example.ecommerceapp.data.SignupViewModel
import com.example.ecommerceapp.data.SignupUIEvent

@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .background(Color.White),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChange(it))

                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError

                )
                MyTextField(
                    labelValue = stringResource(id = R.string.last_name ),
                    painterResource = painterResource(id = R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))

                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError

                )
                MyTextField(
                    labelValue = stringResource(id = R.string.email ),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))

                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError

                )
                PasswordTextField(
                    labelValue = stringResource(id = R.string.password ),
                    painterResource = painterResource(id = R.drawable.password),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))

                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError

                )
                CheckboxComponent(value = stringResource(id = R.string.term_and_contract),
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    } )
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(value = stringResource(id = R.string.register), onButtonClicked = {
                    signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                },
                    isEnabled = signupViewModel.allValidationsPassed.value )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })
            }

        }
        if (signupViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}