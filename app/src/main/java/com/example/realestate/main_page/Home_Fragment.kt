package com.example.realestate.main_page

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realestate.data_items.Data_builds
import com.example.realestate.R
import com.example.realestate.adapter.BuildsAdapter
import com.example.realestate.adapter.ParentAdapter
import com.example.realestate.data_items.Parent_items
import com.example.realestate.databinding.FragmentHomeBinding
import com.example.realestate.page_sartup.page_ditilesOneFragment
import java.util.*
import kotlin.collections.ArrayList

class Home_Fragment : Fragment() {

lateinit var binding: FragmentHomeBinding

//    private lateinit var buildList: ArrayList<Data_builds>
//    private lateinit var buildsAdapterDA: BuildsAdapter

    private lateinit var parentList: ArrayList<Parent_items>
    private lateinit var buildsAdapter: ParentAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recBuilds.setHasFixedSize(true)

//        val layoutManager = GridLayoutManager(context,2)

        binding.recBuilds.layoutManager = LinearLayoutManager(context)

        parentList = ArrayList()
//        buildList = ArrayList()

//        buildsAdapter = ParentAdapter(parentList)

//        buildsAdapterDA = BuildsAdapter(buildList)
//        binding.recBuilds.adapter = buildsAdapterDA

        buildsAdapter = ParentAdapter(parentList)
        binding.recBuilds.adapter = buildsAdapter

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
            val filteredList = ArrayList<Parent_items>()
            for (i in parentList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(context, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                buildsAdapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {

//        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
//        buildList.add(Data_builds(R.drawable.build1, "Om2 Sree heights"))
//        buildList.add(Data_builds(R.drawable.build1, "Om3 Sree heights"))
//        buildList.add(Data_builds(R.drawable.build1, "Om4 Sree heights"))
//        buildList.add(Data_builds(R.drawable.build1, "Om5 Sree heights"))

        val childItems1 = ArrayList<Data_builds>()
        childItems1.add(Data_builds(R.drawable.build1,"Om home average", "by Om Sree builders &amp; Dev...", "58000$"))
        childItems1.add(Data_builds(R.drawable.h1,"dragon home heights", "by Om Sree builders &amp; Dev...", "120000$"))
        childItems1.add(Data_builds(R.drawable.h2,"blue home heights", "by Om Sree builders &amp; Dev...", "90000$"))
        childItems1.add(Data_builds(R.drawable.h3,"red home heights", "by Om Sree builders &amp; Dev...", "76000$"))
        childItems1.add(Data_builds(R.drawable.h4,"flower home heights", "by Om Sree builders &amp; Dev...", "85000$"))
        childItems1.add(Data_builds(R.drawable.h5,"good home heights", "by Om Sree builders &amp; Dev...", "89000$"))
        childItems1.add(Data_builds(R.drawable.m1,"woo home average", "by Om Sree builders &amp; Dev...", "54000$"))
        childItems1.add(Data_builds(R.drawable.m2,"hello home average", "by Om Sree builders &amp; Dev...", "50000$"))


        parentList.add(Parent_items("Featured properties", childItems1))


        val childItems2 = ArrayList<Data_builds>()
        childItems2.add(Data_builds(R.drawable.h1,"dragon home heights", "by Om Sree builders &amp; Dev...", "120000$"))
        childItems2.add(Data_builds(R.drawable.h2,"blue home heights", "by Om Sree builders &amp; Dev...", "90000$"))
        childItems2.add(Data_builds(R.drawable.h3,"red home heights", "by Om Sree builders &amp; Dev...", "76000$"))
        childItems2.add(Data_builds(R.drawable.h4,"flower home heights", "by Om Sree builders &amp; Dev...", "85000$"))
        childItems2.add(Data_builds(R.drawable.h5,"good home heights", "by Om Sree builders &amp; Dev...", "89000$"))

        parentList.add(Parent_items("high level", childItems2))


        val childItems3 = ArrayList<Data_builds>()
        childItems3.add(Data_builds(R.drawable.m1,"woo home average", "by Om Sree builders &amp; Dev...", "54000$"))
        childItems3.add(Data_builds(R.drawable.m2,"hello home average", "by Om Sree builders &amp; Dev...", "50000$"))
        childItems3.add(Data_builds(R.drawable.m3,"chifo home average", "by Om Sree builders &amp; Dev...", "65000$"))
        childItems3.add(Data_builds(R.drawable.m4,"mouse home average", "by Om Sree builders &amp; Dev...", "58000$"))

        parentList.add(Parent_items("average level", childItems3))


        val childItems4 = ArrayList<Data_builds>()
        childItems4.add(Data_builds(R.drawable.l1,"cat home low", "by Om Sree builders &amp; Dev...", "33000$"))
        childItems4.add(Data_builds(R.drawable.build1,"ni home low", "by Om Sree builders &amp; Dev...", "22000$"))
        childItems4.add(Data_builds(R.drawable.build1,"gero home low", "by Om Sree builders &amp; Dev...", "10000$"))
        childItems4.add(Data_builds(R.drawable.l4,"byy home low", "by Om Sree builders &amp; Dev...", "15000$"))

        parentList.add(Parent_items("low level", childItems4))



//        buildsAdapter.notifyDataSetChanged()
    }
}