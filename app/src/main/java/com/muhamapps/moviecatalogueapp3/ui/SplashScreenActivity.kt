package com.muhamapps.moviecatalogueapp3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.muhamapps.moviecatalogueapp3.R
import com.muhamapps.moviecatalogueapp3.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            startActivity(
                Intent(this,
                HomeActivity::class.java)
            )
            finish()
        }, 3500)
    }
}