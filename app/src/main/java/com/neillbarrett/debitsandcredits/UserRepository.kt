package com.neillbarrett.debitsandcredits

import androidx.annotation.WorkerThread
import com.neillbarrett.debitsandcredits.database.Dao
import com.neillbarrett.debitsandcredits.database.Users
import kotlinx.coroutines.flow.Flow

class UserRepository(private val Dao: Dao) {

    val allUsers: Flow<List<Users>> = Dao.getAllUsers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(users: Users){
        Dao.addUser(List<users>())
    }

}