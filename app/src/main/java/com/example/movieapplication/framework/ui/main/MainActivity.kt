package com.example.movieapplication.framework.ui.main

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ActivityMainBinding
import com.example.movieapplication.databinding.FragmentGenreBinding
import com.example.movieapplication.framework.ui.MainBroadCastReceiver
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navigation: Navigation
    private lateinit var toolbar: Toolbar
    private val receiver = MainBroadCastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation = Navigation(supportFragmentManager)
        navigation.addFragment(MainFragment.newInstance(), false)

        //CONNECTIVITY_ACTION deprecated
        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        initToolbar()
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    fun getNavigation(): Navigation {
        return navigation
    }

    fun initToolbar(): Toolbar {
        toolbar = binding.myToolbar
        setSupportActionBar(toolbar)
        return toolbar
    }

}


