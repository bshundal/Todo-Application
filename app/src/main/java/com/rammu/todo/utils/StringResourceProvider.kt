package com.rammu.todo.utils

import androidx.annotation.StringRes

interface StringResourceProvider {
    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, vararg args: Any): String
}