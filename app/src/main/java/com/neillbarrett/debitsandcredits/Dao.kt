package com.neillbarrett.debitsandcredits

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // User queries
    @Insert
    suspend fun insertUser(user: MutableList<UsersTable>)
    //suspend fun insertUser(user: List<UsersTable>)

/*    @Update
    suspend fun updateUser(user: String)*/

    //@Transaction
    @Query("SELECT * FROM UsersTable ORDER BY UserName ASC")
    fun getAllUsers(): Flow<MutableList<UsersTable?>>

/*    @Query("DELETE FROM UsersTable")
    suspend fun deleteUsers()*/

    // Payment type queries
    /*@Insert
    suspend fun addPaymentType(pymtType: List<Type>) */
}