package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // User queries
    @Insert
    fun insertUser(usersTable: UsersTable)
    //suspend fun insertUser(usersTable: UsersTable)
    //suspend fun insertUser(user: List<UsersTable>)

    @Update
    fun updateUser(usersTable: UsersTable)
    //suspend fun updateUser(usersTable: UsersTable)

    //@Transaction
    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): Flow<MutableList<UsersTable?>>

    @Delete
    fun deleteUser(usersTable: UsersTable)
    //suspend fun deleteUser(usersTable: UsersTable)

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}