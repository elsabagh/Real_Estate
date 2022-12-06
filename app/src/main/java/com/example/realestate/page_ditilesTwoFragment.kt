package com.example.realestate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.databinding.FragmentPageDitilesTwoBinding

class page_ditilesTwoFragment : AppCompatActivity() {

    lateinit var binding: FragmentPageDitilesTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPageDitilesTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_start()
    }

    private fun btn_start() {
        binding.buttonStart2.setOnClickListener {
            val intent = Intent(this, Login_Fragment::class.java)
            startActivity(intent)
        }
    }

}