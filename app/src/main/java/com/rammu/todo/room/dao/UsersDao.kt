package com.rammu.todo.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rammu.todo.room.tables.Users


@Dao
interface UsersDao {

   @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(users: Users)

@Query("SELECT * FROM users WHERE userMobileNo = :userMobileNo AND userPassword = :userPassword")
    suspend fun getUserByCredentials(userMobileNo: String,userPassword: String): Users
}