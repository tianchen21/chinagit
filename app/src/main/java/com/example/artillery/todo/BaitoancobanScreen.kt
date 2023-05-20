package com.example.artillery.todo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.artillery.R

class BaitoancobanScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.baitoancobanscreen_design)
    }

    fun gc_btn(view: View) {
        val intent = Intent(this, GaochengScreen::class.java)
        startActivity(intent)
    }
    fun sjx_btn(view: View) {
        val intent = Intent(this, SanjiaoxingScreen::class.java)
        startActivity(intent)
    }


}