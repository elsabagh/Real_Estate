package com.example.realestate.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realestate.R
import com.example.realestate.adapter.BuildsAdapter
import com.example.realestate.adapter.ListSetAdapter
import com.example.realestate.data_items.Data_builds
import com.example.realestate.data_items.Parent_items
import com.example.realestate.databinding.FragmentHomeBinding
import com.example.realestate.databinding.FragmentSettingBinding
import java.util.*
import kotlin.collections.ArrayList

class Setting_Fragment : Fragment() {

    lateinit var binding: FragmentSettingBinding

    private lateinit var buildList: ArrayList<Data_builds>
    private lateinit var buildsAdapterS: ListSetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recBuilds.setHasFixedSize(true)

        binding.recBuilds.layoutManager = LinearLayoutManager(context)

        buildList = ArrayList()

        buildsAdapterS = ListSetAdapter(buildList)
        binding.recBuilds.adapter = buildsAdapterS
        addDataToList()
    }

    private fun addDataToList() {

        buildList.add(Data_builds(R.drawable.ic_baseline_account_circle_24, "Profile"))
        buildList.add(Data_builds(R.drawable.ic_baseline_language_24, "language"))
        buildList.add(Data_builds(R.drawable.ic_baseline_support_agent_24, "support"))
        buildList.add(Data_builds(R.drawable.ic_baseline_location_on_24, "location"))
        buildList.add(Data_builds(R.drawable.ic_baseline_report_24, "report"))
        buildList.add(Data_builds(R.drawable.ic_baseline_payment_24, "payment"))
        buildList.add(Data_builds(R.drawable.ic_baseline_settings_24, "settings"))
        buildList.add(Data_builds(R.drawable.ic_baseline_login_24, "logout"))

    }
}