package com.example.notesmanager.core.utils

import android.content.Context
import javax.inject.Inject


internal class AndroidServices @Inject constructor(
    private val context: Context
) : IAndroidServices {

    override fun getString(resId: Int): String = context.getString(resId)
}