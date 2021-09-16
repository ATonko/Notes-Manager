package com.example.notesmanager.core

import android.app.Application
import com.example.notesmanager.di.DaggerManager

open class ApplicationClass : Application() {

    private lateinit var daggerManager: DaggerManager

    override fun onCreate() {
        super.onCreate()

        daggerManager = DaggerManager.apply {
            plusAppComponent(this@ApplicationClass)
        }
    }
}