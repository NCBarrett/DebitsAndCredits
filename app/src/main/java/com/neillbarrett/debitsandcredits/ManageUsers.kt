package com.neillbarrett.debitsandcredits

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.CoroutinesRoom
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neillbarrett.debitsandcredits.database.CreditsAndDebitsApp
import com.neillbarrett.debitsandcredits.database.DebitsAndCreditsDB
import com.neillbarrett.debitsandcredits.database.UsersTable
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class ManageUsers : AppCompatActivity() {

    lateinit var binding: ActivityManageUsersBinding
    lateinit var recyclerView: RecyclerView
    lateinit var editTextAddUser: EditText
    lateinit var editTextUpdateUser: EditText
    lateinit var newUser: String
    lateinit var updateUser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_manage_users)

        //Get a reference to the binding object and inflate the view
        binding = ActivityManageUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnAddUser = findViewById<Button>(R.id.btn_AddUser)
        val btnChangeUser = findViewById<Button>(R.id.btn_ChangeUserName)
        val btnDeleteUser = findViewById<Button>(R.id.btn_DeleteUser)
        recyclerView = findViewById(R.id.rec_view_userList)
        editTextAddUser = findViewById(R.id.et_UserName)
        editTextUpdateUser = findViewById(R.id.et_Edit_Name)

/*        val adapter = UserListAdapter()
        binding.recViewUserList.adapter = adapter*/

        val database = DebitsAndCreditsDB.getDatabase(this, CoroutineScope(SupervisorJob()))
        val viewModelFactory = UserViewModelFactory(database.dao, Application())
        val userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.recViewUserList.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@ManageUsers)
            adapter = UserListAdapter()
        }

        //recyclerView.adapter?.notifyDataSetChanged()

        btnAddUser.setOnClickListener {
            if (TextUtils.isEmpty(editTextAddUser.text)) {
                Toast.makeText(this, "User name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                newUser = editTextAddUser.text.toString()
                //userViewModel.insertUser()
                //database.dao.insertUser()
                database.dao.insertUser(UsersTable(0, newUser))
/*                lifecycleScope.launch {

                }*/
            }
        }

        btnChangeUser.setOnClickListener {
            val item : Int
/*            if (){

            }*/
        }
    }

}