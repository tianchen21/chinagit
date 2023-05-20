package com.example.artillery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.artillery.databinding.JingmifascreenDesignBinding

class JingmifaScreen: AppCompatActivity() {

    private lateinit var binding: JingmifascreenDesignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JingmifascreenDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Step1jmf())
        binding.bottomNavigationView2.setOnItemSelectedListener {

            when(it.itemId){

                R.id.step1 ->replaceFragment(Step1jmf())
                R.id.step2 ->replaceFragment(Step2jmf())
                R.id.step3 ->replaceFragment(Step3jmf())
                else -> {

                }
            }

            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout2,fragment)
        fragmentTransaction.commit()
    }
}