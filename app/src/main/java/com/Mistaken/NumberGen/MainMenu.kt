package com.Mistaken.NumberGen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.daniel.firstappdaniel.OneNumberGenerator
import com.daniel.firstappdaniel.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.apply { title = "NumberGen App" }
        initLoadAds()
        AdManager.initLoadAds(this)
    }

    private fun initLoadAds() {
        val adRequest: AdRequest = AdRequest.Builder().build()
        val adView: AdView = findViewById(R.id.banner)
        adView.loadAd(adRequest)
    }

    fun oneNumberGen(View: View)
    {
        val intent = Intent(this, OneNumberGenerator::class.java)
        startActivity(intent)
        AdManager.showInterstitialAd(this)
    }
    fun siONo(View: View)
    {
        val intent2 = Intent(this,YesOrNo::class.java)
        startActivity(intent2)
        AdManager.showInterstitialAd(this)
    }

    fun namePicker(View: View)
    {
        val intent3 = Intent(this,NamePicker::class.java)
        startActivity(intent3)
        AdManager.showInterstitialAd(this)
    }

    fun multiNumberGen(View: View)
    {
        val intent4 = Intent(this,MultipleNumberGenerator::class.java)
        startActivity(intent4)
        AdManager.showRewardedAd(this) { }
    }

    fun multiNamePicker(View: View)
    {
        val intent5 = Intent(this, MultipleNamePicker::class.java)
        startActivity(intent5)
        AdManager.showRewardedAd(this) { }
    }

    fun numberGuesser(View: View)
    {
        val intent6 = Intent(this, NumberGuesser::class.java)
        startActivity(intent6)
        AdManager.showRewardedAd(this) { }
    }
}