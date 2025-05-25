package com.rammu.todo.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext



class AndroidStringResourceProvider(
    @ApplicationContext private val context: Context // Use @ApplicationContext for Hilt
) : StringResourceProvider {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }
    override fun getString(resId: Int, vararg args: Any): String {
        return context.getString(resId, *args)
    }
}