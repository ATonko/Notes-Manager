package com.example.notesmanager.core.utils

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.toolbar.*

fun Fragment.getToolbar(): Toolbar = this.vToolbar

fun <T : Fragment> T.withArguments(params: Bundle.() -> Unit): T {
    this.arguments = Bundle().apply(params)
    return this
}