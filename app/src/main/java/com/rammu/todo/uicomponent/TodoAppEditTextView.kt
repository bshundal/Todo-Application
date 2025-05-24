package com.rammu.todo.uicomponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import com.rammu.todo.R

@Composable
fun TodoAppEditTextView(value:String, isError:Boolean,modifier: Modifier= Modifier,
                        labelText:String,keyboardType:KeyboardType=KeyboardType.Text,
                        onValueChange:(String)->Unit,) {

    val focusManager= LocalFocusManager.current



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
        singleLine = true)
}

