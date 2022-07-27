package com.neillbarrett.debitsandcredits

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.CreditsAndDebitsApp

class ListOfUsers : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as CreditsAndDebitsApp).repository)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
            if (result.resultCode == Activity.RESULT_OK) {

            } else {

            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_users)

        val recyclerView = findViewById<RecyclerView>(R.id.lv_ListOfUsers)
    }
}