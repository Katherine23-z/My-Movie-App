package com.example.movieapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.Repository
import com.example.movieapplication.databinding.MainFragmentBinding

class MainFragment : Fragment(){
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val horrorList = Repository.getMovieList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val horrorRecycler: RecyclerView = binding.recyclerHorrors
        horrorRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        horrorRecycler.adapter = HorrorRecyclerAdapter(horrorList)

        val thrillerRecycler: RecyclerView = binding.recyclerThrillers
        thrillerRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        thrillerRecycler.adapter = ThrillerRecyclerAdapter(horrorList)

        val comedyRecycler: RecyclerView = binding.recyclerComedies
        comedyRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        comedyRecycler.adapter = ComedyRecyclerAdapter(horrorList)

        val serialRecycler: RecyclerView = binding.recyclerSerials
        serialRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        serialRecycler.adapter = SerialsRecyclerAdapter(horrorList)

        val horrorHeader: TextView = binding.headerHorrors

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




