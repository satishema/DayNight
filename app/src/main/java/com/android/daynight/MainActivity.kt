package com.android.daynight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.android.daynight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        if (delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            binding.dayNightMode.setImageResource(R.drawable.ic_light)
        } else {
            binding.dayNightMode.setImageResource(R.drawable.ic_moon_dark)
        }

        binding.dayNightMode.setOnClickListener {

            if (delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
}