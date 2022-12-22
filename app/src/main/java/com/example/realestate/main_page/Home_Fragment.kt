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
        childItems1.add(Data_builds(R.drawable.build1,"Om1 Sree heights"))
        childItems1.add(Data_builds(R.drawable.build1,"Om2 Sree heights"))
        childItems1.add(Data_builds(R.drawable.build1,"Om3 Sree heights"))
        childItems1.add(Data_builds(R.drawable.build1,"Om4 Sree heights"))


        parentList.add(Parent_items("Featured properties", childItems1))


        val childItems2 = ArrayList<Data_builds>()
        childItems2.add(Data_builds(R.drawable.build1,"Om20 Sree heights"))
        childItems2.add(Data_builds(R.drawable.build1,"Om21 Sree heights"))
        childItems2.add(Data_builds(R.drawable.build1,"Om23 Sree heights"))
        childItems2.add(Data_builds(R.drawable.build1,"Om24 Sree heights"))


        parentList.add(Parent_items("high level", childItems2))


        val childItems3 = ArrayList<Data_builds>()
        childItems3.add(Data_builds(R.drawable.build1,"Om30 Sree heights"))
        childItems3.add(Data_builds(R.drawable.build1,"Om31 Sree heights"))
        childItems3.add(Data_builds(R.drawable.build1,"Om33 Sree heights"))
        childItems3.add(Data_builds(R.drawable.build1,"Om34 Sree heights"))


        parentList.add(Parent_items("average level", childItems3))

        val childItems4 = ArrayList<Data_builds>()
        childItems4.add(Data_builds(R.drawable.build1,"Om40 Sree heights"))
        childItems4.add(Data_builds(R.drawable.build1,"Om41 Sree heights"))
        childItems4.add(Data_builds(R.drawable.build1,"Om43 Sree heights"))
        childItems4.add(Data_builds(R.drawable.build1,"Om44 Sree heights"))


        parentList.add(Parent_items("low level", childItems4))



//        buildsAdapter.notifyDataSetChanged()
    }
}