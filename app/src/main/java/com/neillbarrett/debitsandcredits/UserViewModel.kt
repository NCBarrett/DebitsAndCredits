package com.neillbarrett.debitsandcredits

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.neillbarrett.debitsandcredits.database.UsersTable
import kotlinx.coroutines.launch

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
        repository.insertUser(UsersTable(0, userName = user))
    }
}