package com.ktapp.hb.kotlinapp.Models

import java.io.Serializable

class User(data: HashMap<String, Any>) : Serializable {

    var userName: String = ""
    var password: String = ""

    fun description() : String {
        return "You are logged in as $userName"
    }

    init {
        this.userName = data["name"].toString()
        this.password = data["pass"].toString()
    }

    companion object {
        fun getUsersList() : List<User> {
            var anArray = mutableListOf<User>()
            val user1 = User(data = hashMapOf("name" to "SB", "pass" to "123456"))
            val user2 = User(data = hashMapOf("name" to "CP", "pass" to "123456"))
            val user3 = User(data = hashMapOf("name" to "NG", "pass" to "123456"))
            val user4 = User(data = hashMapOf("name" to "VY", "pass" to "123456"))
            anArray.add(user1)
            anArray.add(user2)
            anArray.add(user3)
            anArray.add(user4)
            return anArray
        }
    }
}
