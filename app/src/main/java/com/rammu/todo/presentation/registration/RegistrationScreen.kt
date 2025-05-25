package com.rammu.todo.presentation.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rammu.todo.R
import com.rammu.todo.uicomponent.TodoAppButton
import com.rammu.todo.uicomponent.TodoAppEditTextView
import com.rammu.todo.uicomponent.TodoAppSpacer
import com.rammu.todo.uicomponent.TodoAppTextView

@Composable
fun RegistrationScreen(uiState: RegistrationUiState,
                       onEvent:(RegistrationFormEvents)-> Unit,
                       modifier: Modifier = Modifier,
                       viewModel: RegistrationViewModel = hiltViewModel(),
                       onBackPress: () -> Unit,

                       ){
    Scaffold {paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoAppSpacer(40.dp)
            TodoAppTextView(txt = stringResource(R.string.register_title), textStyle = typography.displayLarge)
            TodoAppSpacer(80.dp)
            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userName,
                isError = uiState.userNameError,
                labelText = stringResource(R.string.user_name_title),
                keyboardType = KeyboardType.Text,
                supportingText = uiState.userNameErrorMsg,
                onValueChange = {value->
                    onEvent(RegistrationFormEvents.OnUserNameChange(value))
                }
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userMobileNo,
                isError = uiState.userMobileNoError,
                labelText = stringResource(R.string.mobile_title),
                supportingText = uiState.userMobileNoErrorMsg,
                keyboardType = KeyboardType.Number,
                onValueChange = {value->
                    onEvent(RegistrationFormEvents.OnMobileNoChange(value))
                }
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userEmail,
                isError = uiState.userEmailError,
                labelText = stringResource(R.string.email_title),
                keyboardType = KeyboardType.Email,
                supportingText = uiState.userEmailErrorMsg,
                onValueChange = {value->
                    onEvent(RegistrationFormEvents.OnEmailChange(value))
                }
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userPassword,
                isError = uiState.userPasswordError,
                labelText = stringResource(R.string.user_password_title),
                keyboardType = KeyboardType.Password,
                supportingText = uiState.userPasswordErrorMsg,
                onValueChange = {value->
                    onEvent(RegistrationFormEvents.OnPasswordChange(value))
                }
            )

            TodoAppSpacer(40.dp)
            TodoAppButton(btnTxt = stringResource(R.string.register_title)) {
              onEvent(RegistrationFormEvents.OnSubmit(onBackPress))
            }



    }
}

}

@Composable
@Preview
fun RegistrationPreview(){
  //  RegistrationScreen() {  }

}