package com.neillbarrett.debitsandcredits

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neillbarrett.debitsandcredits.database.Dao
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(private val dataSource: Dao, application: Application) : AndroidViewModel(application) {

    val database = dataSource

    val allUsers = dataSource.getAllUsers()

    fun insertUser(usersTable: UsersTable) = viewModelScope.launch(

    )
}