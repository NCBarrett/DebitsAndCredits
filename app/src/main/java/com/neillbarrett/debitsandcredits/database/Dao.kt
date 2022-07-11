package com.neillbarrett.debitsandcredits.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface Dao {

    @Insert
    fun addUser(user: List<Users>)

    @Query("SELECT * FROM Users")
    fun getAllUsers(): List<Users>
}