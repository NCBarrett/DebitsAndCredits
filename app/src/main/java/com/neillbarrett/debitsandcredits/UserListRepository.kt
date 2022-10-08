package com.neillbarrett.debitsandcredits

import androidx.annotation.WorkerThread
import com.neillbarrett.debitsandcredits.database.Dao
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.flow.Flow

class UserRepository(private val Dao: Dao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allUsers: Flow<List<UsersTable?>> = Dao.getAllUsers()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(user: UsersTable) = Dao.insertUser(user)
/*    suspend fun insertUser(usersTable: List<UsersTable>) {
        Dao.insertUser(usersTable)
    }*/

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateUser(user: UsersTable) = Dao.updateUser(user)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteUser(user: UsersTable) = Dao.deleteUser(user)
}