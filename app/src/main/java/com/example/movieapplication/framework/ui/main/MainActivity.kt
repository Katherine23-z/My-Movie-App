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

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val search: MenuItem? = menu?.findItem(R.id.action_search)
        val searchText = search?.actionView as androidx.appcompat.widget.SearchView
        searchText.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add -> Snackbar.make(mainView, getString(R.string.add_to_favourite), Snackbar.LENGTH_LONG).show()
            R.id.action_settings -> navigation.addFragment(SettingsFragment.newInstance(), true)
        }
        return super.onOptionsItemSelected(item)
    }*/
}


