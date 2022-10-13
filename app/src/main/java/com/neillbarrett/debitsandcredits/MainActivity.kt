package com.neillbarrett.debitsandcredits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.History
import com.neillbarrett.ManageTransactions
import com.neillbarrett.debitsandcredits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        binding.btnUpdateUsers.setOnClickListener {
            startActivity(Intent(this@MainActivity, ManageUsers::class.java))
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this@MainActivity, History::class.java))
        }

        binding.btnUpdateTransactions.setOnClickListener {
            startActivity(Intent(this@MainActivity, ManageTransactions::class.java))
        }
    }
}