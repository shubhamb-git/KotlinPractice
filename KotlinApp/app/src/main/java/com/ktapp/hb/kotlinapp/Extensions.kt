package com.ktapp.hb.kotlinapp

import android.app.Activity
import android.widget.Toast
import android.content.Context

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}