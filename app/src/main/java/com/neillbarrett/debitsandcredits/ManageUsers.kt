package com.neillbarrett.debitsandcredits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.CreditsAndDebitsApp
import com.neillbarrett.debitsandcredits.database.UsersTable
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding
//import java.util.Observer

class ManageUsers : AppCompatActivity() {

    lateinit var binding: ActivityManageUsersBinding
    lateinit var recyclerView: RecyclerView
    lateinit var editTextAddUser: EditText
    lateinit var newUser: String
    lateinit var user: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityManageUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_manage_users)

        val userViewModel: UserViewModel by viewModels {
            UserViewModelFactory((application as CreditsAndDebitsApp).repository)
        }

        recyclerView = findViewById(R.id.rec_view_userList)
        editTextAddUser = findViewById(R.id.et_UserName)

        val adapter = UserListAdapter(user)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.allUsers.observe(this, androidx.lifecycle.Observer { user ->
            user?.let { adapter.submitList(it) }
        })

        val btnAddUser = findViewById<Button>(R.id.btn_AddUser)
        btnAddUser.setOnClickListener {
            if (TextUtils.isEmpty(editTextAddUser.text)) {
                Toast.makeText(this, "User name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                newUser = editTextAddUser.text.toString()
//                Log.i("Add user button", "Username put into newUser")
                userViewModel.insertUser(UsersTable(0, newUser))
//                Toast.makeText(this, "Username added to table", Toast.LENGTH_SHORT).show()
//                Log.i("Add user button", "Username added to table")
            }
        }

        UserListAdapter(user).onItemClick

        val btnChangerUser = findViewById<Button>(R.id.btn_ChangeUserName)
        btnChangerUser.setOnClickListener {
            if (adapter.onItemClick!!.equals(-1)){
                Toast.makeText(this, "Selected a name.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Selected position is ${adapter.onItemClick.toString()}.",
                    Toast.LENGTH_LONG).show()
            }
        }

    }
}