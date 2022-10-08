package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import androidx.room.Dao
import androidx.room.OnConflictStrategy.*
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // User queries
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UsersTable)
    //suspend fun insertUser(usersTable: UsersTable)
    //suspend fun insertUser(user: List<UsersTable>)

    @Update
    fun updateUser(user: UsersTable)
    //suspend fun updateUser(usersTable: UsersTable)

    //@Transaction
    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): Flow<MutableList<UsersTable?>>

    @Delete
    fun deleteUser(user: UsersTable)
    //suspend fun deleteUser(usersTable: UsersTable)

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}