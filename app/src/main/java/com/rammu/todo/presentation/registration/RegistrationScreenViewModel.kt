package com.rammu.todo.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor() : ViewModel(){
    var userName by mutableStateOf("")
    var userMobile by mutableStateOf("")
    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf("")
}