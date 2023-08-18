package com.daniel.firstappdaniel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.EditText
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        supportActionBar?.apply { title = "Number Generator" }

        val numInput1 = findViewById<EditText>(R.id.numInput1)
        val numInput2 = findViewById<EditText>(R.id.numInput2)
        val resultText = findViewById<TextView>(R.id.resultText)
    }

    fun numRandom(view: View) {
        val numInput1 = findViewById<EditText>(R.id.numInput1)
        val numInput2 = findViewById<EditText>(R.id.numInput2)
        val aviso = findViewById<TextView>(R.id.aviso)

        val num1 = numInput1.text.toString().toLongOrNull()
        val num2 = numInput2.text.toString().toLongOrNull()

        if (num1 != null && num2 != null) {
            val menor = min(num1, num2)
            val mayor = max(num1, num2)
            val random = Random.nextLong(menor, mayor + 1)

            val texto = findViewById<TextView>(R.id.num)
            texto.text = "$random"
            tamañoTexto()
            aviso.text = "Your number generated between $menor and $mayor is:"
        } else {
            aviso.text = "Cannot leave blank fields!"
        }
    }

    fun tamañoTexto() {
        val display = findViewById<TextView>(R.id.num)
        display.textSize = when (display.text.length) {
            1 -> 120f
            2 -> 100f
            3 -> 70f
            4 -> 55f
            5 -> 40f
            6 -> 35f
            7 -> 30f
            8 -> 27f
            9 -> 25f
            10 -> 22f
            11 -> 20f
            12 -> 18f
            13 -> 17f
            14 -> 15f
            15 -> 14f
            16 -> 13f
            17 -> 12f
            else -> 11.5f
        }
    }
}
