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
        var texto = findViewById<TextView>(R.id.num)
        var selector1 = findViewById<EditText>(R.id.selector1)
        var selector2 = findViewById<EditText>(R.id.selector2)
    }

    fun numRandom(view: View)
    {
        var selector1 = findViewById<EditText>(R.id.selector1)
        var selector2 = findViewById<EditText>(R.id.selector2)
        val num1 = selector1.text.toString().toLong()
        val num2 = selector2.text.toString().toLong()

        val menor = min(num1, num2)
        val mayor = max(num1, num2)
        val random = Random.nextLong(menor, mayor+1)
        var texto = findViewById<TextView>(R.id.num)
        texto.text = "$random"
        tamañoTexto()

        var aviso = findViewById<TextView>(R.id.aviso)
        aviso.text = "Su número generado entre $menor y $mayor es:"
    }

    fun tamañoTexto()
    {
        var display = findViewById<TextView>(R.id.num)
        display.textSize = when (display.text.length)
        {
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