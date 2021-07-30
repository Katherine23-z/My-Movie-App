package com.example.movieapplication.framework.ui.history_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.databinding.FragmentHistoryBinding
import com.example.movieapplication.framework.ui.main.adapters.HistoryAdapter
import com.example.movieapplication.viewmodel.AppState
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HistoryViewModel by lazy {
        ViewModelProvider(this).get(HistoryViewModel::class.java)
    }

    private val adapter: HistoryAdapter by lazy { HistoryAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyRecyclerView.adapter = adapter
        viewModel.historyLiveData.observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getAllHistory()
    }

    private fun renderData(appState: AppState) = with(binding){
        when(appState){
            is AppState.Success -> {
                adapter.setData(appState.movieData)
            }
            is AppState.Loading -> {

            }
            is AppState.Error ->{

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance() = HistoryFragment()
    }

}