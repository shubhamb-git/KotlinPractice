package com.ktapp.hb.kotlinapp.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ktapp.hb.kotlinapp.R
import com.ktapp.hb.kotlinapp.Models.User
import com.ktapp.hb.kotlinapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var usersList = User.getUsersList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton.setOnClickListener {
            this.loginButtonAction()
        }
    }
    // Login button clicked
    private  fun loginButtonAction() {
        val filteredArray = usersList.filter {(it.userName.toString() == this.userNameTextField.text.toString()
            .toString()) && (it.password.toString() == this.passwordTextField.text.toString())}
        if (filteredArray.count() > 0) {
            redirectToHomeScreenWith(user = filteredArray[0])
        } else {
            showToast("User not found")
        }
    }
    // Redirect to Home screen
    private fun redirectToHomeScreenWith(user: User) {
        Log.d("selectedUser", user.userName)
        showToast("Logged in with ${user.userName.toString()}")

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("loggedUser", user)
        intent.putExtra("userName", user.userName.toString())
        startActivity(intent)
    }

    private fun showFragment() {

    }
}
