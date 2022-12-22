package com.example.realestate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.R
import com.example.realestate.data_items.Data_builds
import com.example.realestate.data_items.Parent_items
import java.util.*
import kotlin.collections.ArrayList

class ParentAdapter (private var parentList: List<Parent_items>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {


    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv: TextView = itemView.findViewById(R.id.parentTitleTv)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.langRecyclerView)

    }

    fun setFilteredList(parentList: ArrayList<Parent_items>){
        this.parentList = parentList

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = parentList[position]
        holder.titleTv.text = parentItem.title

        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.HORIZONTAL, false)
        val adapter = BuildsAdapter(parentItem.bList)
        holder.childRecyclerView.adapter = adapter


    }

    override fun getItemCount(): Int {
        return parentList.size
    }
}