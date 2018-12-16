package com.ktapp.hb.kotlinapp.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ktapp.hb.kotlinapp.Adapter.HobbiesAdapter
import com.ktapp.hb.kotlinapp.R
import com.ktapp.hb.kotlinapp.Models.Supplier
import kotlinx.android.synthetic.main.hobbies_activity.*


class  HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hobbies_activity)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recycleView.adapter = adapter
    }
}