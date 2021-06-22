package com.example.movieapplication.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.movieapplication.R

class Navigation(val manager: FragmentManager) {

    fun addFragment(fragment: Fragment?, useBackstack: Boolean) {
        val fragmentTransaction = manager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment!!)
        if (useBackstack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}