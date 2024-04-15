package com.example.ecommerceapp.data

sealed class SignupUIEvent {
    data class FirstNameChange(val firstName:String) : SignupUIEvent()
    data class LastNameChanged(val lastName:String) : SignupUIEvent()
    data class EmailChanged(val email:String) : SignupUIEvent()
    data class PasswordChanged(val password:String) : SignupUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status: Boolean) : SignupUIEvent()
    object RegisterButtonClicked : SignupUIEvent()
}