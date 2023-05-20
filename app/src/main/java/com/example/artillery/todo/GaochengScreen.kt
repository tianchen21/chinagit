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


class GaochengScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaochengscreen_design)
    }

    fun results_btn(view: View) {
        val Ha = findViewById<EditText>(R.id.haip).text.toString().toDouble()
        val D = findViewById<EditText>(R.id.dip).text.toString().toDouble()
        val e = findViewById<EditText>(R.id.eip).text.toString().toDouble()
        val i = findViewById<EditText>(R.id.iip).text.toString().toDouble()
        val L = findViewById<EditText>(R.id.lip).text.toString().toDouble()
        //chuyen doi textedit sang number
        if (findViewById<RadioButton>(R.id.rb_1).isChecked){
            val Hb = Gaocheng1(Ha, D, e, i, L)
            dapan(Hb)
        }
        else{
            val Hb = Gaocheng2(Ha, D, e, i, L)
            dapan(Hb)
        }
    }
    fun dapan(Hb: Double){
        findViewById<TextView>(R.id.hbgc).text = Hb.toString()
    }
    fun drections_btn(view: View){
        setPopup(view)
    }
    fun setPopup(view : View){
        val new= getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val popupView = new.inflate(R.layout.popup_gc,null)

        val popupWindow = PopupWindow(popupView,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        popupWindow.isFocusable = true

        popupWindow.showAtLocation(view,Gravity.CENTER,0,0)
    }

}