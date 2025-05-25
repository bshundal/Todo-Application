package com.rammu.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rammu.todo.presentation.registration.RegistrationFormEvents


@Composable
fun rememberTodoAppNavController(navController: NavHostController = rememberNavController()):TodoAppNavController=
    remember(navController) {
      TodoAppNavController(navController)
    }


@Stable
class TodoAppNavController(val navController: NavHostController){

private val currentRoute: String ?
    get() =navController.currentDestination?.route



    fun onBackPress(){
        navController.navigateUp()
    }


    fun onNavigationFromSplashScreen(isLogin: Boolean){
        if(isLogin){
           navController.navigate(Screens.HOME_SCREEN)
        }else{
            navController.navigate(Screens.LOGIN_SCREEN)
        }
    }


    fun navigateToRegisterScreen(from: NavBackStackEntry){
      if(shouldNavigate(from)){
         navController.navigate(Screens.REGISTRATION_SCREEN)
      }
    }

   

    fun navigateToHomeScreen(from: NavBackStackEntry){
        if(shouldNavigate(from)){
            navController.navigate(Screens.HOME_SCREEN)
        }

    }
}

private fun shouldNavigate(from: NavBackStackEntry): Boolean=from.lifeCycleIsResumed()

private fun NavBackStackEntry.lifeCycleIsResumed()=this.lifecycle.currentState== Lifecycle.State.RESUMED