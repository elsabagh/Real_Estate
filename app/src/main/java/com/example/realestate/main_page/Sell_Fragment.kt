package com.example.realestate.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.realestate.R
import com.example.realestate.adapter.BuildsAdapter
import com.example.realestate.data_items.Data_builds
import com.example.realestate.databinding.FragmentSellBinding
import com.example.realestate.databinding.FragmentSettingBinding
import java.util.*
import kotlin.collections.ArrayList


class Sell_Fragment : Fragment() {


    lateinit var binding: FragmentSellBinding

    private lateinit var buildList: ArrayList<Data_builds>
    private lateinit var buildsAdapterDA: BuildsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recBuilds.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(context,2)

        buildList = ArrayList()

        buildsAdapterDA = BuildsAdapter(buildList)
        binding.recBuilds.adapter = buildsAdapterDA
        addDataToList()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }


    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Data_builds>()
            for (i in buildList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(context, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                buildsAdapterDA.setFilteredListD(filteredList)
            }
        }
    }

    private fun addDataToList() {

        buildList.add(Data_builds(R.drawable.build1,"Om home average", "by Om Sree builders &amp; Dev...", "58000$"))
        buildList.add(Data_builds(R.drawable.h1,"dragon home heights", "by Om Sree builders &amp; Dev...", "120000$"))
        buildList.add(Data_builds(R.drawable.h4,"flower home heights", "by Om Sree builders &amp; Dev...", "85000$"))
        buildList.add(Data_builds(R.drawable.h5,"good home heights", "by Om Sree builders &amp; Dev...", "89000$"))
        buildList.add(Data_builds(R.drawable.h4,"flower home heights", "by Om Sree builders &amp; Dev...", "85000$"))
        buildList.add(Data_builds(R.drawable.m2,"hello home average", "by Om Sree builders &amp; Dev...", "50000$"))
        buildList.add(Data_builds(R.drawable.build1,"ni home low", "by Om Sree builders &amp; Dev...", "22000$"))
        buildList.add(Data_builds(R.drawable.m4,"mouse home average", "by Om Sree builders &amp; Dev...", "58000$"))
        buildList.add(Data_builds(R.drawable.l4,"byy home low", "by Om Sree builders &amp; Dev...", "15000$"))
    }
}