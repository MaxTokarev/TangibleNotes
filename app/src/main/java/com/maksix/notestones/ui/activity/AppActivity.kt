package com.maksix.notestones.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maksix.notestones.R
import com.maksix.notestones.ui.list.NotesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, NotesListFragment())
                .commitNow()
        }
    }
}
