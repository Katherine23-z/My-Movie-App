package com.example.movieapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ActivityMainBinding
import com.example.movieapplication.ui.main.MainFragment
import com.example.movieapplication.ui.main.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navigation: Navigation
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation = Navigation(supportFragmentManager)
        navigation.addFragment(MainFragment.newInstance(), false)

        initToolbar()
    }

    fun getNavigation(): Navigation {
        return navigation
    }

    fun initToolbar(): Toolbar {
        toolbar = binding.myToolbar
        setSupportActionBar(toolbar)
        return toolbar
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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
            R.id.action_clear -> Snackbar.make(mainView, getString(R.string.delete), Snackbar.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}


