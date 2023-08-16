package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.daniel.firstappdaniel.R
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        supportActionBar?.apply { title = "Multiple Number Generator" }
    }

    fun numsRandom(view: View)
    {
        val selector1 = findViewById<EditText>(R.id.selector1)
        val selector2 = findViewById<EditText>(R.id.selector2)
        val aviso = findViewById<TextView>(R.id.aviso)
        val amount = findViewById<EditText>(R.id.amount)
        val num1 = selector1.text.toString().toLongOrNull()
        val num2 = selector2.text.toString().toLongOrNull()
        val size = amount.text.toString().toIntOrNull()


        if (num1 != null && num2 != null && size != null)
        {
            if (size > 0 && size <= 300)
            {
                val menor = min(num1, num2)
                val mayor = max(num1, num2)
                val texto = findViewById<TextView>(R.id.num)
                var randomNumbers = mutableListOf<Long>()
                for (i in 0 until size) {
                    var randomNumber = Random.nextLong(menor, mayor + 1)
                    randomNumbers.add(randomNumber)
                }
                aviso.text = "Your generated numbers are:"
                val formattedNumbers = randomNumbers.chunked(10) // Group by 5 numbers
                    .map { it.joinToString(", ") } // Join each group with comma and space
                    .joinToString(",\n")
                texto.text = formattedNumbers
            }
            else
            {
                aviso.text = "The amount has to be between 1 and 300!"
            }
        }
        else
        {
            aviso.text = "Cannot leave blank fields!"
        }
    }
}