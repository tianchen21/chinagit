package com.example.artillery.todo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.artillery.R
import com.example.artillery.todo.jichuyunsuan.*
class HomeScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen_design)
    }

    fun btcb_btn(view: View){
        val intent = Intent(this, BaitoancobanScreen::class.java)
        startActivity(intent)
    }
    fun tptb_btn(view: View) {
        val intent = Intent(this, TinhphantubanScreen::class.java)
        startActivity(intent)
    }

}