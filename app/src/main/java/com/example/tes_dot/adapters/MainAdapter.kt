package com.example.tes_dot.adapters

import android.content.Context
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes_dot.R
import com.example.tes_dot.models.ModelData
import com.example.tes_dot.utils.ApiClient
import com.squareup.picasso.Picasso

class MainAdapter(val context: Context, val datas: ArrayList<ModelData>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)

        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val data = datas.get(position)
        holder.tv1.text = data.title
        holder.tv2.text = data.content
        Toast.makeText(context, data.content,Toast.LENGTH_SHORT).show()
        holder.imglist.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.imglist.adapter = ImageAdapter(context, data.media!!)
    }

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imglist: RecyclerView
        val tv1: TextView
        val tv2: TextView

        init {
            imglist = view.findViewById(R.id.rc2)
            tv1 = view.findViewById(R.id.tv_title)
            tv2 = view.findViewById(R.id.tv_desc)
        }
    }

}