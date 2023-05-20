package com.example.artillery.todo

import android.content.Context
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
import com.example.artillery.todo.jichuyunsuan.*
class SanjiaoxingScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sanjiaoxingscreen_design)
    }

    fun results_btn(view: View) {
        val Aa = findViewById<EditText>(R.id.aasjx).text.toString().toDouble()
        val Ab = findViewById<EditText>(R.id.absjx).text.toString().toDouble()
        val Dab = findViewById<EditText>(R.id.dabsjx).text.toString().toDouble()

        //chuyen doi textedit sang number
        if (findViewById<RadioButton>(R.id.rbsjx_1).isChecked) {
            val (Dac,Dbc) = sanjiaoxingmw(Aa,Ab,Dab)
            findViewById<TextView>(R.id.dacsjx).text = Dac.toString()
            findViewById<TextView>(R.id.dbcsjx).text = Dbc.toString()
        } else {
            val (Dac,Dbc) = sanjiaoxingdu(Aa,Ab,Dab)
            findViewById<TextView>(R.id.dacsjx).text = Dac.toString()
            findViewById<TextView>(R.id.dbcsjx).text = Dbc.toString()
        }
    }


}