package com.example.jonathan.testroomdb.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    //suspend fun insertUser(user: User)
    @Insert
    fun insertUser(user: User)

    // Remove "suspend" modifier which does not work well with LiveData:
    //suspend fun getAllUsers(): List<User>
    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>
}
