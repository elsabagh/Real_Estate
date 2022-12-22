package com.example.realestate.main_page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.data_items.Data_builds
import com.example.realestate.databinding.ActivityDetailsPageBinding

class Details_Page : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val build = intent.getParcelableExtra<Data_builds>("build")
        if (build != null){
            val nameBuild = binding.textDetails
            val imageBuild = binding.imageViewDetails

            nameBuild.text = build.name
            imageBuild.setImageResource(build.image)
        }

    }

}