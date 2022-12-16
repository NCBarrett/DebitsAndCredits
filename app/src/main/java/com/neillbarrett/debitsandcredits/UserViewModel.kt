package com.neillbarrett.debitsandcredits

import android.util.Log
import androidx.lifecycle.*
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

val inViewModel: String = "In UserViewModel "

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allUsers: LiveData<List<UsersTable>> = repository.allUsers.asLiveData()
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

    fun insertUser(user: UsersTable) = viewModelScope.launch {
        repository.insertUser(user)
        Log.w(inViewModel,"insertUser called")
    //repository.insertUser(usersTable = List<UsersTable>())
    //repository.insertUser(UsersTable(0, userName = user.userName))
    }

    fun updateUser(user: UsersTable) = viewModelScope.launch {
        repository.updateUser(user)
        Log.w(inViewModel, "updateUser called")
    }

    fun deleteUser(user: UsersTable) = viewModelScope.launch {
        repository.deleteUser(user)
        Log.w(inViewModel, "deteUser called")
    }
}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.w(inViewModel,"UserViewModelFactory called")
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}