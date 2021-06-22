package com.example.movieapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.viewmodel.AppState
import com.example.movieapplication.databinding.MainFragmentBinding
import com.example.movieapplication.model.Movie
import com.example.movieapplication.ui.main.adapters.ComedyRecyclerAdapter
import com.example.movieapplication.ui.main.adapters.HorrorRecyclerAdapter
import com.example.movieapplication.ui.main.adapters.SerialsRecyclerAdapter
import com.example.movieapplication.ui.main.adapters.ThrillerRecyclerAdapter
import com.example.movieapplication.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(){
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var navigation: Navigation
    private lateinit var mainView : LinearLayout
    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!
    private var movieGenre: String = "horror"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val horrorRecycler: RecyclerView = binding.recyclerHorrors
        horrorRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        horrorRecycler.adapter = HorrorRecyclerAdapter(object : OnItemViewClickListener{
            override fun onItemViewClick(movie: Movie) {
                val bundle = Bundle()
                bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                navigation.addFragment(MovieCardFragment.newInstance(bundle), true)
            }

        })

        val thrillerRecycler: RecyclerView = binding.recyclerThrillers
        thrillerRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        thrillerRecycler.adapter = ThrillerRecyclerAdapter(object : OnItemViewClickListener{
            override fun onItemViewClick(movie: Movie) {
                val bundle = Bundle()
                bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                navigation.addFragment(MovieCardFragment.newInstance(bundle), true)
            }
        })

        val comedyRecycler: RecyclerView = binding.recyclerComedies
        comedyRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        comedyRecycler.adapter = ComedyRecyclerAdapter(object : OnItemViewClickListener{
            override fun onItemViewClick(movie: Movie) {
                val bundle = Bundle()
                bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                navigation.addFragment(MovieCardFragment.newInstance(bundle), true)
            }
        })

        val serialRecycler: RecyclerView = binding.recyclerSerials
        serialRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        serialRecycler.adapter = SerialsRecyclerAdapter(object : OnItemViewClickListener{
            override fun onItemViewClick(movie: Movie) {
                val bundle = Bundle()
                bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                navigation.addFragment(MovieCardFragment.newInstance(bundle), true)
            }
        })

        val activity : MainActivity = context as MainActivity
        navigation = activity.getNavigation()

        val horrorHeader: TextView = binding.headerHorrors
        horrorHeader.setOnClickListener {
            navigation.addFragment(GenreFragment.newInstance(), true)
        }

        val thrillerHeader: TextView = binding.headerThrillers
        thrillerHeader.setOnClickListener {
            navigation.addFragment(GenreFragment.newInstance(), true)
        }

        val comedyHeader: TextView = binding.headerComedies
        comedyHeader.setOnClickListener {
            navigation.addFragment(GenreFragment.newInstance(), true)
        }

        val serialHeader: TextView = binding.headerSerials
        serialHeader.setOnClickListener {
            navigation.addFragment(GenreFragment.newInstance(), true)
        }

        mainView = binding.mainView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer{renderData(it as AppState)})
        viewModel.getDataFromLocalSourceHorrors()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                Snackbar.make(mainView, "Success", Snackbar.LENGTH_LONG).show()
            }
            is AppState.Loading -> {
                Snackbar.make(mainView, "Loading", Snackbar.LENGTH_LONG).show()
            }
            is AppState.Error -> {
                Snackbar
                        .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Reload") { viewModel.getDataFromLocalSourceHorrors() }
                        .show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }
}




