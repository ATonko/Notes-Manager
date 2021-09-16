package com.example.notesmanager.core.utils

import androidx.annotation.StringRes

internal interface IAndroidServices {
    fun getString(@StringRes resId: Int): String
}
