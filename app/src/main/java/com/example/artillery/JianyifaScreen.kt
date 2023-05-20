package com.example.artillery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.artillery.databinding.JianyifascreenDesignBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import main.kotlin.jyf

class JianyifaScreen: AppCompatActivity() {

    private lateinit var binding: JianyifascreenDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JianyifascreenDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Step1())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.step1 -> replaceFragment(Step1())
                R.id.step2 -> replaceFragment(Step2())
                R.id.step3 -> replaceFragment(Step3())
                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}
