package com.example.ecommerceapp.components

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R

@Composable
fun NormalTextComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String, painterResource: Painter){
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        label = {Text(text = labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimamry),
            focusedLabelColor = colorResource(id = R.color.colorPrimamry),
            cursorColor = colorResource(id = R.color.colorPrimamry),
            unfocusedContainerColor = colorResource(id = R.color.colorTextField),
            focusedContainerColor = colorResource(id = R.color.colorWhite)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, modifier = Modifier
                .width(24.dp)
                .height(24.dp), contentDescription = null)
        },

    )

}

@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter){
    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        label = {Text(text = labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimamry),
            focusedLabelColor = colorResource(id = R.color.colorPrimamry),
            cursorColor = colorResource(id = R.color.colorPrimamry),
            unfocusedContainerColor = colorResource(id = R.color.colorTextField),
            focusedContainerColor = colorResource(id = R.color.colorWhite)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, modifier = Modifier
                .width(24.dp)
                .height(24.dp), contentDescription = null)
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description = if(passwordVisible.value){
                stringResource(id = R.string.hidden_password)
            }else{
                stringResource(id = R.string.show_password)
            }
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(imageVector = iconImage , contentDescription = description)
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None
        else {PasswordVisualTransformation()}
    )

}

@Composable
fun CheckboxComponent(value: String, onTextSelected: (String) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember{
            mutableStateOf(false)
        }
            Checkbox(checked = checkedState.value , onCheckedChange ={
                checkedState.value != checkedState.value
            })
        ClickableTextComponent(value =value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String)-> Unit){
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimamry))){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimamry))){
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    ClickableText(text = annotatedString, onClick ={offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTextComponent","{$span}")
                if((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }


    } )
}

@Composable
fun ButtonComponent(value: String){
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        colorResource(id = R.color.colorSecondary),
                        colorResource(id = R.color.colorPrimamry)
                    )
                ),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center)
        {
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerTextComponent(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center ) {
        Spacer(modifier = Modifier.weight(1f))
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGray),
            thickness = 1.dp)
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true,onTextSelected: (String)-> Unit){
    val initialText = if(tryingToLogin)"Already have an account? " else "Don't have an account yet? "
    val LoginText = if(tryingToLogin)"Login" else "Register"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimamry))){
            pushStringAnnotation(tag = LoginText, annotation = LoginText)
            append(LoginText)
        }

    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .padding(10.dp),

        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick ={offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTextComponent","{$span}")
                if((span.item == LoginText)){
                    onTextSelected(span.item)
                }
            }


    } )
}

@Composable
fun UnderLinedTextComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}
