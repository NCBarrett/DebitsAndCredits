package com.neillbarrett.debitsandcredits.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neillbarrett.debitsandcredits.Users

@Dao
interface Dao {

    @Query("INSERT INTO Users (UserName) VALUES (:user)")
    fun addUser(user: Users)

}