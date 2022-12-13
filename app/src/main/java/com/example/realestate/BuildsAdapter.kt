package com.example.realestate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuildsAdapter(private var buildsList:ArrayList<Data_builds>)
    :RecyclerView.Adapter<BuildsAdapter.BuildViewHolder>() {

        class BuildViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView){
            val imageView : ImageView = itemsView.findViewById(R.id.image_build)
            val textView: TextView = itemsView.findViewById(R.id.textView3)
        }

    fun setFilteredList(buildsList: ArrayList<Data_builds>){
        this.buildsList = buildsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.builds_item , parent , false)
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