package com.rammu.todo.data.models

data class LoginResponse(val userId: Int?,
                         val userName: String,
                         val userMobileNo: String,
                         val userEmailId: String,
                         val userPassword: String
)
