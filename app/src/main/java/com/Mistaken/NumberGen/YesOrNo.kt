package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.daniel.firstappdaniel.R
import kotlin.random.Random

class YesOrNo : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yesorno)
        supportActionBar?.apply { title = "Yes or No?" }
        AdManager.initLoadAds(this)
    }

    fun siONo(View: View) {
        val siONo = findViewById<TextView>(R.id.siONo)
        val imagen = findViewById<ImageView>(R.id.checkOrX)
        val random = Random.nextBoolean();

        if (random) {
            siONo.text = "No!"
            imagen.setImageResource(R.drawable.x)
        } else {
            siONo.text = "Yes!"
            imagen.setImageResource(R.drawable.checkmark)
        }
        count++
        if (count == 5) {
            AdManager.showInterstitialAd(this)
            count = 0
        }
    }
}