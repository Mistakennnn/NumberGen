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

        var aviso = findViewById<TextView>(R.id.aviso)
        aviso.text = "Su número generado entre $menor y $mayor es:"
    }
}