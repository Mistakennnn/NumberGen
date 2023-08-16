package com.Mistaken.NumberGen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.daniel.firstappdaniel.FirstActivity
import com.daniel.firstappdaniel.R

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.apply { title = "NumberGen App" }
    }

    fun oneNumberGen(View: View)
    {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }
    fun siONo(View: View)
    {
        val intent2 = Intent(this,SecondActivity::class.java)
        startActivity(intent2)
    }

    fun namePicker(View: View)
    {
        val intent3 = Intent(this,ThirdActivity::class.java)
        startActivity(intent3)
    }

    fun multiNumberGen(View: View)
    {
        val intent4 = Intent(this,FourthActivity::class.java)
        startActivity(intent4)
    }
}