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
    suspend fun insertUser(user: List<UsersTable>)
    //suspend fun insertUser(user: UsersTable)

    @Transaction
    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): Flow<List<UsersTable>>

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}