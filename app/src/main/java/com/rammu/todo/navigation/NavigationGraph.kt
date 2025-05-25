package com.rammu.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rammu.todo.presentation.login.LoginScreen
import com.rammu.todo.presentation.login.LoginViewModel
import com.rammu.todo.presentation.registration.RegistrationScreen
import com.rammu.todo.presentation.registration.RegistrationViewModel
import com.rammu.todo.presentation.splash.SplashScreen
import com.rammu.todo.ui.theme.TodoAppTheme


@Composable
fun NavigationGraph( startDestination: String) {
    TodoAppTheme {
        val todoAppNavController = rememberTodoAppNavController()
        NavHost(
            navController = todoAppNavController.navController,
            startDestination = startDestination) {
            todoAppGraph(
                onBackPress = todoAppNavController::onBackPress,
                onNavigationFromSplashScreen = todoAppNavController::onNavigationFromSplashScreen,
                onNavigateToRegistration = todoAppNavController::navigateToRegisterScreen
            )
        }
    }

}

fun NavGraphBuilder.todoAppGraph(onBackPress:()->Unit,
                                 onNavigationFromSplashScreen:(Boolean)->Unit,
                                 onNavigateToRegistration:(NavBackStackEntry)-> Unit){
   navigation(route= Screens.HOME_SCREEN, startDestination = Screens.SPLASH_SCREEN){


}

     composable(route= Screens.SPLASH_SCREEN){from->
         SplashScreen(onNavigationFromSplashScreen = remember {
              { onNavigationFromSplashScreen(it) }
         })
     }

     composable(route= Screens.LOGIN_SCREEN){from->
         val viewModel: LoginViewModel=hiltViewModel()
         LoginScreen(  uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
             onEvent = viewModel::onFormEvent,
             onNavigateToRegistration = remember {
             { onNavigateToRegistration(from) }
         })
     }

     composable (route= Screens.REGISTRATION_SCREEN){from->
       val  viewModel: RegistrationViewModel= hiltViewModel()
         RegistrationScreen(
             uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
             onEvent = viewModel::onFormEvent,
             onBackPress= remember {
                 { onBackPress }
             })
     }
}