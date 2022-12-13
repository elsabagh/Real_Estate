package com.example.realestate.page_sartup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Registration_Fragment: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        have_acount()

        register_btn()
    }

    private fun have_acount() {
        binding.textLogin.setOnClickListener {
            val intent = Intent(this, Login_Fragment::class.java)
            startActivity(intent)
        }
    }

    private fun register_btn() {
        binding.buttonRegister.setOnClickListener {
            Perform_Registration()
        }
    }


    private fun Perform_Registration() {
        val inputEmail = binding.textEmailReg.text.toString()
        val inputPass = binding.textPassReg.text.toString()

        if (inputEmail.isBlank() || inputPass.isBlank()){
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(inputEmail, inputPass).addOnCompleteListener(this){
            if (it.isSuccessful){

                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()

            }else{

                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}