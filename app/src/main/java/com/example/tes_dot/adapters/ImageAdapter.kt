package com.example.tes_dot.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tes_dot.R
import com.squareup.picasso.Picasso

class ImageAdapter(val context: Context, val datas: ArrayList<String>) :
    RecyclerView.Adapter<ImageAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_img, parent, false)

        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val data = datas.get(position)
        Picasso.get().load(data).into(holder.img)
    }

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView

        init {
            img = view.findViewById(R.id.img3)
        }
    }

}