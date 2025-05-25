package com.rammu.todo.di

import android.content.Context
import com.rammu.todo.utils.AndroidStringResourceProvider
import com.rammu.todo.utils.StringResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideStringResourceProvider(@ApplicationContext context: Context): StringResourceProvider {
        return AndroidStringResourceProvider(context)
    }
}