package com.example.movieapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapplication.R
import com.example.movieapplication.databinding.MovieCardBinding
import com.example.movieapplication.model.Movie

class MovieCardFragment : Fragment() {

    companion object {
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieCardFragment {
            val fragment = MovieCardFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: MovieCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MovieCardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Movie>(BUNDLE_EXTRA).let { movie ->
            binding.movieTitle.text = movie?.movieTitle
            binding.movieGenre.text = movie?.movieGenre
            binding.movieDuration.text = movie?.movieDuration.toString()
            binding.movieRelease.text = movie?.yearOfRelease.toString()
            binding.poster.setImageResource(R.drawable.cosmos)
        }

    }


}