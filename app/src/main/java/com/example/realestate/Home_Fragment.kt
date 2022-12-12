package com.example.realestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.databinding.FragmentHomeBinding

class Home_Fragment : Fragment() {

lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
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

        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))
        buildList.add(Data_builds(R.drawable.build1, "Om Sree heights"))

        buildsAdapter = BuildsAdapter(buildList)
        binding.recBuilds.adapter = buildsAdapter


    }
}