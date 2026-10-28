package com.example.eco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.eco.ListAdapter.MyViewHolder
import com.example.eco.data.Task

class ListAdapter: Adapter<MyViewHolder>() {

    private var itemList = emptyList<Task>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val customTasktxt = itemView.findViewById<TextView>(R.id.customTask)
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = itemList[position]
        holder.customTasktxt.text = currentItem.task
        holder.checkBox.isChecked = currentItem.progress
    }

    fun setData(item: List<Task>) {
        this.itemList = item
        notifyDataSetChanged()
    }
}