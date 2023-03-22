package com.maksix.notestones.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maksix.notestones.R
import com.maksix.notestones.other.Navigator
import com.maksix.notestones.ui.list.NotesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheme(R.style.Theme_NotesStones)
        if (savedInstanceState == null) {
            Navigator(supportFragmentManager).routeTo(
                fragment = NotesListFragment(),
                addToBackStack = false
            )
        }
    }
}