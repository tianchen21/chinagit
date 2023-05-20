package com.example.artillery.todo

import android.os.Bundle

import android.content.Intent

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.artillery.JianyifaScreen
import com.example.artillery.JingmifaScreen
import com.example.artillery.R

class TinhphantubanScreen:  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tinhphantubanscreen_design)
    }
    fun jyf_btn(view: View) {
        val intent = Intent(this, JianyifaScreen::class.java)
        startActivity(intent)
    }
    fun jmf_btn(view: View) {
        val intent = Intent(this, JingmifaScreen::class.java)
        startActivity(intent)
    }
}