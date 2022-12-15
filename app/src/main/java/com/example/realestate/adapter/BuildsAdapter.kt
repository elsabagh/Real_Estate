package com.example.realestate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.data_items.Data_builds
import com.example.realestate.R

class BuildsAdapter(private var buildsList:List<Data_builds>)
    :RecyclerView.Adapter<BuildsAdapter.BuildViewHolder>() {

        class BuildViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView){
            val imageView : ImageView = itemsView.findViewById(R.id.image_build)
            val textView: TextView = itemsView.findViewById(R.id.textView3)
        }

    fun setFilteredListD(buildsList: ArrayList<Data_builds>){
        this.buildsList = buildsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent , false)
        return BuildViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuildViewHolder, position: Int) {
        val build = buildsList[position]
        holder.imageView.setImageResource(build.image)
        holder.textView.text = build.name
    }

    override fun getItemCount(): Int {
        return buildsList.size
    }

}