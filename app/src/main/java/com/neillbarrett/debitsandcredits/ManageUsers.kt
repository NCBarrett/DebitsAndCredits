package com.neillbarrett.debitsandcredits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding

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

        val adapter = UserListAdapter()

        binding.recViewUserList.adapter = adapter
    }

}