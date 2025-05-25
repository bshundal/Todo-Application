// di/DatabaseModule.kt
package com.rammu.todo.di

import android.content.Context
import androidx.room.Room
import com.rammu.todo.room.dao.UsersDao
import com.rammu.todo.room.db.TodoAppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoAppDb {
        return Room.databaseBuilder(
            context,
            TodoAppDb::class.java,
            "todo_app_db" // Database name
        ).fallbackToDestructiveMigration() // Use this for development, implement migrations for production
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: TodoAppDb): UsersDao {
        return database.userDao()
    }


}