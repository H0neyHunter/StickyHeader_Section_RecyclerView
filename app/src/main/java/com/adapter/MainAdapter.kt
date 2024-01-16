package com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.model.ListModel
import com.usyssoft.stickyheadersectionrecyclerview.R

class MainAdapter(private val context: Context, private val list: List<ListModel>):RecyclerView.Adapter<MainAdapter.d>() {
    inner class d(v:View):RecyclerView.ViewHolder(v) {
        val childString = v.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): d {
        val l = LayoutInflater.from(context).inflate(R.layout.design_main_row,parent,false)
        return d(l)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: d, position: Int) {
        val item = list[position]
        holder.childString.text = item.child.childString
    }
}