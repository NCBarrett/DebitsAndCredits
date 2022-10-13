package com.neillbarrett.debitsandcredits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding

class ManageUsers : AppCompatActivity() {

    lateinit var binding: ActivityManageUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_manage_users)

        binding = ActivityManageUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

/*        val userListViewModel: UserListViewModel by viewModels {
            UserListViewModelFactory((application as DebitsAndCreditsDao), application)
        }*/

        val dataSource = TransactionsDB.getInstance(application).userListDao
        val viewModelFactory = UserListViewModelFactory(dataSource, application)

        val userListViewModel = ViewModelProvider(this, viewModelFactory).get(UserListViewModel::class.java)

        binding.userListViewModel = userListViewModel
        binding.setLifecycleOwner (this)

        //return binding.root
    }
}