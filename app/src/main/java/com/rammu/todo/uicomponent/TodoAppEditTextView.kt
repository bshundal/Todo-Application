package com.rammu.todo.uicomponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import com.rammu.todo.R

@Composable
fun TodoAppEditTextView(value:String, isError:Boolean,modifier: Modifier= Modifier,
                        labelText:String,keyboardType:KeyboardType=KeyboardType.Text,
                        supportingText: String?=null,
                        onValueChange:(String)->Unit,) {

    val focusManager= LocalFocusManager.current
    val customColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.LightGray.copy(alpha = 0.2f), // Custom focused background
        unfocusedContainerColor = Color.White, // Custom unfocused background
        errorContainerColor = Color.Red.copy(alpha = 0.1f), // Custom error background
        focusedLabelColor = MaterialTheme.colorScheme.primary, // Keep primary for label
        unfocusedLabelColor = Color.Gray, // Custom unfocused label
        errorLabelColor = MaterialTheme.colorScheme.error, // Keep error for label
        focusedIndicatorColor = Color.Blue, // Custom indicator color for focused state
        unfocusedIndicatorColor = Color.Green, // Custom indicator color for unfocused state
        errorIndicatorColor = MaterialTheme.colorScheme.error, // Keep error for indicator
        cursorColor = Color.Red // Custom cursor color
        // ... and many more parameters to customize
    )


    OutlinedTextField(modifier = modifier
        .fillMaxWidth(),
        value = value,
        onValueChange =onValueChange,
        textStyle= typography.labelLarge,
        label ={ TodoAppTextView(txt = labelText, textStyle = typography.labelMedium) },
        keyboardActions = KeyboardActions (
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ), keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError=isError,
        singleLine = true,
        supportingText = { if(isError && !supportingText.isNullOrEmpty()){
            TodoAppTextView(txt = supportingText, color = Color.Red)
        } })



}

