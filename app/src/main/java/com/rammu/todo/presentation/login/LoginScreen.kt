package com.rammu.todo.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rammu.todo.R
import com.rammu.todo.presentation.registration.RegistrationFormEvents
import com.rammu.todo.presentation.registration.RegistrationUiState
import com.rammu.todo.uicomponent.TodoAppButton
import com.rammu.todo.uicomponent.TodoAppEditTextView
import com.rammu.todo.uicomponent.TodoAppSpacer
import com.rammu.todo.uicomponent.TodoAppTextView

@Composable
fun LoginScreen(uiState: LoginUiState,
                onEvent:(LoginEvents)-> Unit,
                modifier: Modifier= Modifier,
                onNavigateToRegistration:()-> Unit,
                viewModel: LoginViewModel= hiltViewModel()){

    Scaffold {paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoAppSpacer(100.dp)
            TodoAppTextView(txt = stringResource(R.string.splash_title), textStyle = typography.displayLarge)
            TodoAppSpacer(150.dp)
            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userMobileNo,
                isError = uiState.userMobileNoError,
                labelText = "User Name",
                keyboardType = KeyboardType.Text,
                supportingText = uiState.userMobileNoErrorMag,
                onValueChange = {value->
                    onEvent(LoginEvents.OnMobileChange(value))
                }
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = uiState.userPassword,
                isError = uiState.userPasswordError,
                labelText = "User Name",
                keyboardType = KeyboardType.Text,
                supportingText = uiState.userPasswordErrorMsg,
                onValueChange = {value->
                    onEvent(LoginEvents.OnPasswordChange(value))
                }

            )

            TodoAppSpacer(40.dp)
            TodoAppButton(btnTxt = "Login") {
               onEvent(LoginEvents.OnSubmit)
            }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                TodoAppTextView(txt = stringResource(id = R.string.no_account),
                    textStyle = typography.titleMedium)


                TodoAppSpacer(4.dp)

                TextButton(onClick = onNavigateToRegistration,
                    contentPadding = PaddingValues(0.dp)) {
                    TodoAppTextView(txt = stringResource(id = R.string.register_now),
                        textStyle = typography.titleLarge) }
            }
        }
    }
}