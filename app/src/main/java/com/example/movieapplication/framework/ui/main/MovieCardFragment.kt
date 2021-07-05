package com.example.movieapplication.framework.ui.main

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.R
import com.example.movieapplication.databinding.MovieCardBinding
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.MovieDTO
import com.example.movieapplication.model.MovieLoader
import com.example.movieapplication.viewmodel.AppState
import com.example.movieapplication.viewmodel.MainViewModel
import com.example.movieapplication.viewmodel.MovieCardViewModel
import com.google.android.material.snackbar.Snackbar

class MovieCardFragment : Fragment() {

    companion object {
        private const val api_key = "60898dfa429c5c8d1deb207e46423f7e"
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieCardFragment {
            val fragment = MovieCardFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val viewModel: MovieCardViewModel by lazy { ViewModelProvider(this).get(MovieCardViewModel::class.java) }
    private var _binding: MovieCardBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MovieCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getParcelable(BUNDLE_EXTRA) ?: Movie()
        movie.let {
            with(binding) {
                movieTitle.text = it.movieTitle
                movieGenre.text = it.movieGenre
                movieDuration.text = it.movieDuration.toString()
                movieRelease.text = it.yearOfRelease.toString()
                viewModel.liveDataToObserve.observe(viewLifecycleOwner, Observer { appState ->
                    when (appState) {
                        is AppState.Success -> {
                            movieDescription.text = appState.movieData[0].overview
                        }
                        is AppState.Loading -> {
                        }
                        is AppState.Error -> {
                        }
                    }
                })
                viewModel.loadData(it.id)
            }
        }
    }

}