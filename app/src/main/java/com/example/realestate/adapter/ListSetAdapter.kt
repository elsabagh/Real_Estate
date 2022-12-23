package com.example.realestate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.R
import com.example.realestate.data_items.Data_List
import com.example.realestate.data_items.Data_builds

class ListSetAdapter(private var DataSell:List<Data_List>)
    :RecyclerView.Adapter<ListSetAdapter.ListSellViewHolder>(){

//    var onItemClick : ((Data_builds) -> Unit)? = null

    class ListSellViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView){
        val imageView : ImageView = itemsView.findViewById(R.id.image_build)
        val textName: TextView = itemsView.findViewById(R.id.textView3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.setting_item, parent, false)
        return ListSellViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListSellViewHolder, position: Int) {
        val sellBuild = DataSell[position]
        holder.apply {
            imageView.setImageResource(sellBuild.image)
            textName.text = sellBuild.name
        }
    }

    override fun getItemCount(): Int {
        return DataSell.size
    }


//        holder.itemView.setOnClickListener {
//            onItemClick?.invoke(build)
//        }

}