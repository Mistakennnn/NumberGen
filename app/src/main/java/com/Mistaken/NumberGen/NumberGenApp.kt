package com.Mistaken.NumberGen

import android.app.Application
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class NumberGenApp: Application {
    constructor() : super()
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        AdManager.initLoadAds(this)
    }
}