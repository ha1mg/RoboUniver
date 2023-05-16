package com.halmg.robouniver.ui.journal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.halmg.robouniver.R

class JournalAdapter(val list: List<Student>) : RecyclerView.Adapter<JournalAdapter.MyViewHolder>() {
    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val studentName: TextView = item.findViewById(R.id.student_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myItem = LayoutInflater.from(parent.context).inflate(R.layout.journal_item, parent, false)
        return  MyViewHolder(myItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.studentName.text = list[position].name
    }
}