package com.example.realestate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.databinding.FragmentStartPageBinding
import com.example.realestate.databinding.FragmentPageDitilesOneBinding

class Start_pageFragment : AppCompatActivity() {

    lateinit var binding: FragmentStartPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStartPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_start()
    }

    private fun btn_start() {
        binding.buttonStart.setOnClickListener {
            click_Start()
        }
    }

    private fun click_Start() {
        val intent = Intent(this, page_ditilesOneFragment::class.java)
        startActivity(intent)
    }


}