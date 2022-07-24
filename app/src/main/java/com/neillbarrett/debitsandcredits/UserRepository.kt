package com.neillbarrett.debitsandcredits

import androidx.annotation.WorkerThread
import com.neillbarrett.debitsandcredits.database.Dao
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class UserRepository(private val Dao: Dao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allUsers: Flow<List<UsersTable>> = Dao.getAllUsers()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(user: UsersTable) {
        Dao.insertUser(user)
    }

}