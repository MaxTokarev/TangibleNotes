package com.maksix.notestones.other

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.maksix.notestones.R

class Navigator(private val fragmentManager: FragmentManager) {
    fun routeTo(
        fragment: Fragment,
        @IdRes containerId: Int = R.id.nav_host_fragment,
        addToBackStack: Boolean = true,
        backStackName: String? = null,
        animation: Animation = Animation.SLIDE_HORIZONTAL
    ) {
        val transaction = fragmentManager.beginTransaction()

        when (animation) {
            Animation.SLIDE_HORIZONTAL -> transaction.setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            Animation.NONE -> Unit
            Animation.SLIDE_VERTICAL -> Unit
        }
        transaction.replace(containerId, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(backStackName)
        }
        transaction.commit()
    }

    enum class Animation {
        SLIDE_HORIZONTAL, NONE, SLIDE_VERTICAL
    }

    fun addFragment(
        fragment: Fragment,
        @IdRes containerId: Int = R.id.nav_host_fragment,
        addToBackStack: Boolean = true,
        backStackName: String? = null
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.slide_out
        )
        transaction.add(containerId, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(backStackName)
        }
        transaction.commit()
    }
}