package com.neillbarrett.debitsandcredits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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

class ManageUsers : AppCompatActivity() {

    lateinit var binding: ActivityManageUsersBinding
    lateinit var recyclerView: RecyclerView
    lateinit var editTextAddUser: EditText
    lateinit var editTextChangeUser: EditText
    lateinit var newUser: String
    var userSelect: ((UsersTable?) -> Unit) = {}
    var position: Long = 0

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
        editTextChangeUser = findViewById(R.id.et_Edit_Name)

        val adapter = UserListAdapter(userSelect)
        binding.recViewUserList.adapter = adapter
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.allUsers.observe(this, Observer() {user ->
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

        val btnChangeUser = findViewById<Button>(R.id.btn_ChangeUserName)
        btnChangeUser.setOnClickListener {
            if (recyclerView.getChildAdapterPosition(it) == -1) {
                Toast.makeText(this, "Select a name.", Toast.LENGTH_SHORT).show()
            } else {
                if (editTextChangeUser.text.toString() == recyclerView.adapter.toString()) {
                    Toast.makeText(this, "Name has not been changed.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Name would have been changed.", Toast.LENGTH_SHORT).show()
                    /*val rvItemRecId: Long
                    rvItemRecId = adapter.getItemId(position.toInt())
                    userViewModel.updateUser(UsersTable(rvItemRecId.toInt(), adapter.toString()))*/
                }
            }
        }
    }
}
