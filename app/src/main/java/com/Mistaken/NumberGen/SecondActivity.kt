package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.daniel.firstappdaniel.R
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun siONo(View: View) {
        val siONo = findViewById<TextView>(R.id.siONo)
        val imagen = findViewById<ImageView>(R.id.checkOrX)
        val random = Random.nextInt(0, 2)

        if (random == 0) {
            siONo.text = "No!"
            imagen.setImageResource(R.drawable.x)
        } else {
            siONo.text = "Sí!"
            imagen.setImageResource(R.drawable.checkmark)
        }
    }
}