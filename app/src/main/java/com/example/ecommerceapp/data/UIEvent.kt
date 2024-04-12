package com.example.ecommerceapp.data

sealed class UIEvent {
    data class FirstNameChange(val firstName:String) : UIEvent()
    data class LastNameChanged(val lastName:String) : UIEvent()
    data class EmailChanged(val email:String) : UIEvent()
    data class PasswordChanged(val password:String) : UIEvent()

    object RegisterButtonClicked : UIEvent()
}