package com.liberty.apps.Fahad.TomandJerry.view.activites

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.android.billingclient.api.SkuDetails
import com.google.android.gms.ads.MobileAds
import com.liberty.apps.Fahad.TomandJerry.AppSettings
//import com.liberty.apps.Fahad.TomandJerry.billing.BillingClass
import com.liberty.apps.Fahad.TomandJerry.databinding.ActivitySplashBinding
import com.onesignal.OneSignal


class SplashActivity : AppCompatActivity() {

    private var binding: ActivitySplashBinding? = null
    // private var billingClass: BillingClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        startMainActivity()
        initGoogleAds()
        initOneSignal()
        // initBilling()

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun initGoogleAds() {
        MobileAds.initialize(
                this
        ) { }
    }

    private fun initOneSignal() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(AppSettings.oneSignalId);
    }

    //private fun initBilling() {
    //  billingClass = BillingClass(this@SplashActivity)
    // billingClass!!.setmCallback(this, this);
    //billingClass!!.startConnection();
    //}

    private fun startMainActivity() {
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this@SplashActivity, ControllerActivity::class.java))
            finish()
        }, 2000)
    }
}



