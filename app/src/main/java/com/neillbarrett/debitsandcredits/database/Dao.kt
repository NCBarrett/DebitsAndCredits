package com.neillbarrett.debitsandcredits.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface Dao {

    @Query("INSERT INTO Users (UserName) VALUES (:user)")
    fun addUser(user: Users)

    @Transaction
    @Query("SELECT * FROM Users")
    fun getAllUsers(): List<Users>
}