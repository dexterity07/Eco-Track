package com.example.eco

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.eco.ListAdapter.MyViewHolder
import com.example.eco.data.Task

class ListAdapter(val context: Context): Adapter<MyViewHolder>() {

    private val prefs = context.getSharedPreferences(
        "POSCart",
        Context.MODE_PRIVATE
    )

    private var itemList =emptyList<Task>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        val customTasktxt = itemView.findViewById<TextView>(R.id.customTask)
        var qt = itemView.findViewById<TextView>(R.id.qt)//val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)
        val btnAdd = itemView.findViewById<Button>(R.id.btnAdd)
        val btnMinus = itemView.findViewById<Button>(R.id.btnMin)



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
        //val quantity = {currentItem.qt}
        val q = "Quantity ${currentItem.qt}"
        var qu = prefs.getInt(q, 1)
        holder.qt.text = qu.toString()

        holder.btnAdd.setOnClickListener {
            qu++

            prefs.edit()
                .putInt(q, qu )
                .apply()

            holder.qt.text = qu.toString()
        }
        holder.btnMinus.setOnClickListener {
            if (qu > 1){
                qu--
                prefs.edit()
                    .putInt(q, qu )
                    .apply()
                holder.qt.text = qu.toString()
            }



        }
        //holder.checkBox.isChecked = currentItem.progress
    }

    fun setData(item: List<Task>) {
        this.itemList = item
        notifyDataSetChanged()
    }
}