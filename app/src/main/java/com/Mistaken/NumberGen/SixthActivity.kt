package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.daniel.firstappdaniel.R
import kotlin.random.Random

class SixthActivity : AppCompatActivity() {
    var num = 0
    var attemptCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)
        supportActionBar?.apply { title = "Number Guesser" }
        num = Random.nextInt(0, 1000)
    }

    fun guess(view: View)
    {
        val editText = findViewById<EditText>(R.id.userInput)
        val userInput = editText.text.toString().toIntOrNull()
        var hint = findViewById<TextView>(R.id.hint)
        var playAgainButton = findViewById<Button>(R.id.playAgainButton)
        if (userInput != null)
        {
            attemptCount++
            if (userInput < num)
            {
                hint.text = "Too low!"
            }
            else if (userInput > num)
            {
                hint.text = "Too high!"
            }
            else if (userInput == num)
            {
                hint.text = "Correct! Took $attemptCount attempts."
                playAgainButton.visibility = View.VISIBLE
                playAgainButton.isEnabled = true
            }
        }
        else
        {
            hint.text = "Cannot leave the field blank!"
        }
    }

    fun playAgain(view: View)
    {
        num = Random.nextInt(0, 1000)
        attemptCount = 0

        var hint = findViewById<TextView>(R.id.hint)
        hint.text = "I thought of another number!"
        var playAgainButton = findViewById<Button>(R.id.playAgainButton)
        playAgainButton.visibility = View.INVISIBLE
        playAgainButton.isEnabled = false
    }
}