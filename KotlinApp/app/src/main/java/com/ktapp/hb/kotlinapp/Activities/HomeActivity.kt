package com.ktapp.hb.kotlinapp.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ktapp.hb.kotlinapp.R
import com.ktapp.hb.kotlinapp.Models.User
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AppCompatActivity() {
    private var usersList = User.getUsersList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val loggedUser = intent.getSerializableExtra("loggedUser")

        if (loggedUser is User) {
            labelUserName.text = loggedUser.description()
        }

        btnList.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}
