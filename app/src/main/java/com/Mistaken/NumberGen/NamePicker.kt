package com.Mistaken.NumberGen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.daniel.firstappdaniel.R
import com.daniel.firstappdaniel.R.id.mostrar
import kotlin.random.Random

class NamePicker : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_namepicker)
        supportActionBar?.apply { title = "Name Picker" }
        AdManager.initLoadAds(this)
    }

    fun pickName(View:View)
    {
        var nameList = findViewById<EditText>(R.id.nameList)
        var mostrar = findViewById<TextView>(mostrar)

        var lines = nameList.text.toString().split("\n")
        var nonEmptyLines = lines.filter { it.isNotBlank() }

        if (nonEmptyLines.isNotEmpty()) {
            var num = Random.nextInt(0, nonEmptyLines.size)
            mostrar.text = nonEmptyLines[num]
            count++
            if (count == 5) {
                AdManager.showInterstitialAd(this)
                count = 0
            }
        } else {
            mostrar.text = "No names available"
        }
    }
}