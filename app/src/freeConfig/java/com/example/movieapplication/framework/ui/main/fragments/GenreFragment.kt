package com.example.movieapplication.framework.ui.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentGenreBinding
import com.example.movieapplication.framework.ui.MAIN_SERVICE_STRING_EXTRA
import com.example.movieapplication.framework.ui.MainService


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            serviceBtn.setOnClickListener {
                Toast.makeText(context, getString(R.string.free_config), Toast.LENGTH_LONG).show()
            }
        }
    }
}