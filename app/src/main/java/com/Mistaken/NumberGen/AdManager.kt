import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

object AdManager {
    private var interstitial: InterstitialAd? = null
    private var rewardedAd: RewardedAd? = null

    fun initLoadAds(context: Context) {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(context, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitial = ad
                }
                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitial = null
                }
            })

        RewardedAd.load(context, "ca-app-pub-3940256099942544/5224354917", adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                }
                override fun onAdFailedToLoad(error: LoadAdError) {
                    rewardedAd = null
                }
            })
    }

    fun showInterstitialAd(activity: Activity) {
        if (interstitial != null) {
            interstitial?.show(activity)
            initLoadAds(activity)
        }
    }

    fun showRewardedAd(activity: Activity, onRewardEarned: () -> Unit) {
        if (rewardedAd != null) {
            rewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdShowedFullScreenContent() {
                    rewardedAd = null
                }

                override fun onAdDismissedFullScreenContent() {
                    initLoadAds(activity)
                }
            }
            rewardedAd?.show(activity) {
                // Callback when the user earns a reward
                onRewardEarned()
            }
        }
    }
}
