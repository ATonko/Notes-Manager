package com.example.notesmanager.core.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.notesmanager.R

fun hideKeyboard(context: Context?, focusedView: View?) {
    context ?: return
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val focus = focusedView ?: (context as? FragmentActivity)?.currentFocus ?: return
    imm.hideSoftInputFromWindow(focus.windowToken, 0)
}

fun FragmentActivity.addFragment(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, fragment, null)
        .addToBackStack(null)
        .commit()

}

fun FragmentActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container, fragment, null)
        .addToBackStack(null)
        .commit()

}

fun FragmentActivity.popBackStackOrFinish() {
    val count = supportFragmentManager.backStackEntryCount
    if (count > 1)
        supportFragmentManager.popBackStack()
    else
        finish()
}
