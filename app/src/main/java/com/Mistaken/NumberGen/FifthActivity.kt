package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.daniel.firstappdaniel.R
import kotlin.random.Random

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        supportActionBar?.apply { title = "Multiple Name Picker" }
    }

    fun pickNames(view: View) {
        val nameList = findViewById<EditText>(R.id.nameList)
        val mostrar = findViewById<TextView>(R.id.mostrar)
        val amount = findViewById<EditText>(R.id.amount)
        val size = amount.text.toString().toIntOrNull()
        val randomNames = mutableListOf<String>()
        val lines = nameList.text.toString().split("\n")
        val nonEmptyLines = lines.filter { it.isNotBlank() }.toMutableList()

        if (size != null && size > 0) {
            for (i in 0 until size) {
                if (nonEmptyLines.isNotEmpty()) {
                    val num = Random.nextInt(0, nonEmptyLines.size)
                    randomNames.add(nonEmptyLines[num])
                    nonEmptyLines.removeAt(num)
                } else {
                    mostrar.text = "No names available."
                    return
                }
            }
            val formattedRandomNames = randomNames.joinToString(", ")
            mostrar.text = formattedRandomNames
        } else {
            mostrar.text = "Must give an amount bigger than 0."
        }
    }
}