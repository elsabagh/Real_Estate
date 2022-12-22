package com.example.realestate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.R
import com.example.realestate.data_items.Data_builds

class ListSetAdapter(private var buildsList:List<Data_builds>)
    :RecyclerView.Adapter<BuildsAdapter.BuildViewHolder>(){

    class BuildViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView){
        val imageView : ImageView = itemsView.findViewById(R.id.image_build)
        val textView: TextView = itemsView.findViewById(R.id.textView3)

    }

    fun setFilteredListD(buildsList: ArrayList<Data_builds>){
        this.buildsList = buildsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuildsAdapter.BuildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.setting_item, parent , false)
        return BuildsAdapter.BuildViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuildsAdapter.BuildViewHolder, position: Int) {
        val build = buildsList[position]
        holder.imageView.setImageResource(build.image)
        holder.textView.text = build.name    }

    override fun getItemCount(): Int {
        return buildsList.size
    }
}