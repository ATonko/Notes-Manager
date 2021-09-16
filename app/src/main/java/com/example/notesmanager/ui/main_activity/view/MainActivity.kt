package com.example.notesmanager.ui.main_activity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notesmanager.R
import com.example.notesmanager.core.utils.addFragment
import com.example.notesmanager.core.utils.popBackStackOrFinish
import com.example.notesmanager.ui.main_activity.presenter.IMainActivityPresenter
import com.example.notesmanager.ui.notes_list.view.NotesListFragment
import com.example.notesmanager.utils.OnBackPressed
import javax.inject.Inject

internal class MainActivity : AppCompatActivity(), IMainActivityView {

    @Inject
    lateinit var presenter: IMainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(NotesListFragment.newInstance())
    }

    override fun onBackPressed() {
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments){
            if (fragment.isVisible && fragment is OnBackPressed){
                (fragment as OnBackPressed).onBackPressed()
                return
            }
        }
        popBackStackOrFinish()
    }

}