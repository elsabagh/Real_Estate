package com.example.realestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.realestate.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val fragmentHome = Home_Fragment()
    val fragmentSetting = Setting_Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        addNavigationListener()

    }

    private fun addNavigationListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.item_Setting ->{ replaceFragment(fragmentSetting)
                    true
                }
                R.id.item_Home-> { replaceFragment(fragmentHome)
                    true
                }
                else -> false
            }
        }
    }


    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

}