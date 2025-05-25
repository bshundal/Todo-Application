package com.rammu.todo.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.room.tables.Users
import kotlinx.coroutines.flow.Flow
import com.rammu.todo.utils.Result

@Dao
interface UsersDao {

   @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(users: Users)

    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE userMobileNo = :userMobileNo)")
    suspend fun isUsernameExist(userMobileNo: String): Boolean

    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE userPassword = :userPassword)")
    suspend fun isPasswordExist(userPassword: String): Boolean


    @Query("SELECT * FROM users WHERE userMobileNo = :userMobileNo AND userPassword = :userPassword")
    fun getUserByCredentials(userMobileNo: String,userPassword: String): LoginResponse?
}