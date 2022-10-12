package com.neillbarrett.debitsandcredits

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DebitsAndCreditsDao {

    @Insert
    suspend fun insertUser(user: UsersTable)

    @Update
    suspend fun updateUser(user: UsersTable)

    @Delete
    suspend fun deleteUser(user: UsersTable)

    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): LiveData<List<UsersTable?>>
}