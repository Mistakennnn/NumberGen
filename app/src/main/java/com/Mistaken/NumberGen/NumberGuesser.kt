package com.Mistaken.NumberGen

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.daniel.firstappdaniel.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlin.random.Random

class NumberGuesser : AppCompatActivity() {
    var num = 0
    var attemptCount = 0
    var personalBest = Int.MAX_VALUE
    lateinit var sharedPreferences: SharedPreferences
    private var interstitial: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbergueser)
        supportActionBar?.apply { title = "Number Guesser" }
        num = Random.nextInt(0, 1000)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        personalBest = sharedPreferences.getInt("personalBest", personalBest)

        initLoadInterAds()

        if (personalBest < Int.MAX_VALUE)
        {
            var PB = findViewById<TextView>(R.id.PB)
            PB.text = "Your personal best is $personalBest attempts."
        }
    }

    fun guess(view: View)
    {
        val editText = findViewById<EditText>(R.id.userInput)
        val userInput = editText.text.toString().toIntOrNull()
        var hint = findViewById<TextView>(R.id.hint)
        var playAgainButton = findViewById<Button>(R.id.playAgainButton)
        var PB = findViewById<TextView>(R.id.PB)
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
                if (attemptCount < personalBest) {
                    personalBest = attemptCount
                    val editor = sharedPreferences.edit()
                    editor.putInt("personalBest", personalBest)
                    editor.apply()
                }
                PB.text = "Your personal best is $personalBest attempts."
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
        interstitial?.show(this)
        num = Random.nextInt(0, 1000)
        attemptCount = 0

        var hint = findViewById<TextView>(R.id.hint)
        hint.text = "I thought of another number!"
        var playAgainButton = findViewById<Button>(R.id.playAgainButton)
        playAgainButton.visibility = View.INVISIBLE
        playAgainButton.isEnabled = false
    }

    private fun initLoadInterAds() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitial = interstitialAd
                }
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitial = null
                }
            }
        )
    }
}