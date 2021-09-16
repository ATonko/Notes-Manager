package com.example.notesmanager.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.notesmanager.R
import com.example.notesmanager.ui.main_activity.view.MainActivity

internal class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(
            { startActivity(Intent(this, MainActivity::class.java)) }, 1500
        )
    }
}