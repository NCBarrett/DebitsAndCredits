package com.neillbarrett.debitsandcredits.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // User queries
    @Insert
    suspend fun addUser(user: List<t_Users>)

    @Transaction
    @Query("SELECT * FROM t_Users ORDER BY UserName ASC")
    fun getAllUsers(): List<t_Users>

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}