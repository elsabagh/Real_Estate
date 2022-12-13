package com.example.realestate

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.databinding.FragmentHomeBinding
import java.util.*
import kotlin.collections.ArrayList

class Home_Fragment : Fragment() {

lateinit var binding: FragmentHomeBinding

    private lateinit var buildList: ArrayList<Data_builds>
    private lateinit var buildsAdapter: BuildsAdapter



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
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recBuilds.layoutManager = layoutManager

        buildList = ArrayList()

        buildsAdapter = BuildsAdapter(buildList)
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
            val filteredList = ArrayList<Data_builds>()
            for (i in buildList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
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

        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om2 Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om3 Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om4 Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om5 Sree heights"))

        buildsAdapter.notifyDataSetChanged()
    }
}