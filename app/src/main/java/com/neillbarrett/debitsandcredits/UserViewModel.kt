package com.neillbarrett.debitsandcredits

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.viewModelFactory
import com.neillbarrett.debitsandcredits.database.Dao
import com.neillbarrett.debitsandcredits.database.DebitsAndCreditsDB
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val allUsers : LiveData<List<UsersTable>> = repository.allUsers.asLiveData()

    fun insertUser(usersTable: UsersTable) = viewModelScope.launch{
        repository.insertUser(usersTable)
    }

    fun updateUser(usersTable: UsersTable) = viewModelScope.launch{
        repository.updateUser(usersTable)
    }

    fun deleteUser(usersTable: UsersTable) = viewModelScope.launch {
        repository.deleteUser(usersTable)
    }
}