package com.ktapp.hb.kotlinapp.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ktapp.hb.kotlinapp.Models.Hobby
import com.ktapp.hb.kotlinapp.R
import com.ktapp.hb.kotlinapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.HobbyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HobbyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        return HobbyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  hobbies.size
    }

    override fun onBindViewHolder(p0: HobbyViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby, p1)
    }

    inner class  HobbyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentIndex: Int = 0

        init {
            itemView.setOnClickListener {
                context.showToast(currentHobby!!.title.toString())
            }

            itemView.imgShare.setOnClickListener {

                val message = "My hobby is:" + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Please select app"))
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            this.currentHobby = hobby
            this.currentIndex = pos
            itemView.txvTitle.text = hobby?.title.toString()
        }
    }
}