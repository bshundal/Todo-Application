package com.rammu.todo.di

import com.rammu.todo.data.repository.LoginRepository
import com.rammu.todo.domain.repositoryimp.LoginRepositoryImp
import com.rammu.todo.source.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun loginRepositoryProvider(localDataSource: LocalDataSource): LoginRepository=
        LoginRepositoryImp(localDataSource)
}