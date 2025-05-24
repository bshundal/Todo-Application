package com.rammu.todo.presentation.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rammu.todo.R
import com.rammu.todo.uicomponent.TodoAppButton
import com.rammu.todo.uicomponent.TodoAppEditTextView
import com.rammu.todo.uicomponent.TodoAppSpacer
import com.rammu.todo.uicomponent.TodoAppTextView

@Composable
fun RegistrationScreen(modifier: Modifier= Modifier, viewModel: RegistrationScreenViewModel= hiltViewModel(),
                       onBackPress:()-> Unit){
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
                value = viewModel.userName,
                isError = false,
                labelText = stringResource(R.string.user_name_title),
                keyboardType = KeyboardType.Text,
                onValueChange = {}
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = viewModel.userMobile,
                isError = false,
                labelText = stringResource(R.string.mobile_title),
                keyboardType = KeyboardType.Number,
                onValueChange = {}
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = viewModel.userEmail,
                isError = false,
                labelText = stringResource(R.string.email_title),
                keyboardType = KeyboardType.Email,
                onValueChange = {}
            )

            TodoAppEditTextView(
                modifier =modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                value = viewModel.userPassword,
                isError = false,
                labelText = stringResource(R.string.user_password_title),
                keyboardType = KeyboardType.Password,
                onValueChange = {}
            )

            TodoAppSpacer(40.dp)
            TodoAppButton(btnTxt = stringResource(R.string.register_title)) {

            }



    }
}

}