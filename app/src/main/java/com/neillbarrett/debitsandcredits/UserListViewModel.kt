package com.neillbarrett.debitsandcredits

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserListViewModel(
    val database: DebitsAndCreditsDao, application: Application) : AndroidViewModel(application) {


}