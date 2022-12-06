package com.example.realestate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.databinding.FragmentPageDitilesOneBinding
import com.example.realestate.databinding.FragmentPageDitilesTwoBinding

class page_ditilesOneFragment : AppCompatActivity() {

    lateinit var binding: FragmentPageDitilesOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPageDitilesOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_start()
    }

    private fun btn_start() {
        binding.buttonStart1.setOnClickListener {
            val intent = Intent(this, page_ditilesTwoFragment::class.java)
            startActivity(intent)
        }
    }

}