package com.rammu.todo.presentation.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rammu.todo.R
import com.rammu.todo.uicomponent.TodoAppTextView
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(viewModel: SplashViewModel=hiltViewModel(), onNavigationFromSplashScreen:(isLogin:Boolean)-> Unit){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TodoAppTextView(txt = stringResource(R.string.splash_title), textStyle = typography.displayLarge)
    }

    LaunchedEffect(Unit) {
        delay(3000)
        onNavigationFromSplashScreen(viewModel.isAlreadyLogin())
    }

}


