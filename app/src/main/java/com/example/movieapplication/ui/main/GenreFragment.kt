package com.example.movieapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapplication.databinding.FragmentGenreBinding


class GenreFragment : Fragment() {
    companion object {
        fun newInstance() = GenreFragment()
    }

    private var _binding : FragmentGenreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentGenreBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}