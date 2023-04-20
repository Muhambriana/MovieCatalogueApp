package com.muhamapps.moviecatalogueapp3.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhamapps.moviecatalogueapp3.R
import com.muhamapps.moviecatalogueapp3.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setLogo(R.drawable.actionbar_icon)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        val sectionsPagerAdapter = SectionsPagerAdapter(this@HomeActivity, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f

    }
}