package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // User queries
    @Insert
    //suspend fun insertUser(user: List<UsersTable>)
    suspend fun insertUser(user: UsersTable)

    @Update
    suspend fun updateUser(user: UsersTable)

    @Transaction
    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): Flow<List<UsersTable>>

    @Delete
    suspend fun deleteUser(user: UsersTable)

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}