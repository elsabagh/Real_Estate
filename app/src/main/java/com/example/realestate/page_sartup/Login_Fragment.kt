package com.example.realestate.page_sartup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realestate.MainActivity
import com.example.realestate.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login_Fragment : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        registration()

        Perform_Log()

        Login_btn()
    }

    private fun Login_btn() {
        binding.buttonLogin.setOnClickListener {
            Perform_Log()
        }
    }

    private fun Perform_Log() {
        val email = binding.textEmailReg.text.toString()
        val pass = binding.textPassReg.text.toString()

        if (email.isBlank() || pass.isBlank()){
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }

    }

    private fun registration() {
        binding.textRegister.setOnClickListener {
            val intent = Intent(this, Registration_Fragment::class.java)
            startActivity(intent)
        }
    }

}