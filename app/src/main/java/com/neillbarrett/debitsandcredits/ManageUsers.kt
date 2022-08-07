package com.neillbarrett.debitsandcredits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.CreditsAndDebitsApp
import com.neillbarrett.debitsandcredits.database.UsersTable
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding

class ManageUsers : AppCompatActivity() {

    lateinit var binding: ActivityManageUsersBinding
    lateinit var recyclerView: RecyclerView
    lateinit var editTextAddUser: EditText
    lateinit var newUser: String
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as CreditsAndDebitsApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityManageUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_manage_users)

        recyclerView = findViewById(R.id.rec_view_userList)

        editTextAddUser = findViewById(R.id.et_UserName)

        val btnAddUser = findViewById<Button>(R.id.btn_AddUser)
        btnAddUser.setOnClickListener {
            if (TextUtils.isEmpty(editTextAddUser.text)) {
                Toast.makeText(this, "User name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                newUser = editTextAddUser.text.toString()
                userViewModel.insertUser(UsersTable(0, newUser))
                //userViewModel.insertUser(editTextAddUser.text.toString())
            }

        }
    }

}