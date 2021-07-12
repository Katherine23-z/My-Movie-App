package com.example.movieapplication.framework.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.movieapplication.R
import com.example.movieapplication.databinding.MovieCardBinding
import com.example.movieapplication.framework.ui.DetailsService
import com.example.movieapplication.framework.ui.ID_EXTRA
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.rest.MovieDTO
import com.example.movieapplication.viewmodel.MovieCardViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_card.*

const val DETAILS_INTENT_FILTER = "DETAILS INTENT FILTER"
const val DETAILS_LOAD_RESULT_EXTRA = "LOAD RESULT"
const val DETAILS_INTENT_EMPTY_EXTRA = "INTENT IS EMPTY"
const val DETAILS_DATA_EMPTY_EXTRA = "DATA IS EMPTY"
const val DETAILS_RESPONSE_EMPTY_EXTRA = "RESPONSE IS EMPTY"
const val DETAILS_REQUEST_ERROR_EXTRA = "REQUEST ERROR"
const val DETAILS_REQUEST_ERROR_MESSAGE_EXTRA = "REQUEST ERROR MESSAGE"
const val DETAILS_URL_MALFORMED_EXTRA = "URL MALFORMED"
const val DETAILS_RESPONSE_SUCCESS_EXTRA = "RESPONSE SUCCESS"
const val DETAILS_OVERVIEW_EXTRA = "OVERVIEW"
private const val PROCESS_ERROR = "Обработка ошибки"

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
    private lateinit var movieBundle: Movie
    private val loadResultReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.getStringExtra(DETAILS_LOAD_RESULT_EXTRA)) {
                DETAILS_INTENT_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_DATA_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_RESPONSE_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_REQUEST_ERROR_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_REQUEST_ERROR_MESSAGE_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_URL_MALFORMED_EXTRA -> TODO(PROCESS_ERROR)
                DETAILS_RESPONSE_SUCCESS_EXTRA -> renderData(MovieDTO(intent.getStringExtra(DETAILS_OVERVIEW_EXTRA)))
                else -> TODO(PROCESS_ERROR)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let {
            LocalBroadcastManager.getInstance(it).registerReceiver(loadResultReceiver, IntentFilter((DETAILS_INTENT_FILTER)))
        }
        setHasOptionsMenu(true)
    }

    override fun onDestroy() {
        context?.let {
            LocalBroadcastManager.getInstance(it).unregisterReceiver(loadResultReceiver)
        }
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MovieCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Movie()
        context?.let {
            it.startService(Intent(it, DetailsService::class.java).apply {
                putExtra(ID_EXTRA, movieBundle.id)
            })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.movie_card_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add -> Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun renderData(movieDTO: MovieDTO) {
        val overview = movieDTO.overview
        if (overview == null) {
            TODO(PROCESS_ERROR)
        } else {

            binding.movieTitle.text = movieBundle.movieTitle
            binding.movieGenre.text = movieBundle.movieGenre
            binding.movieDuration.text = movieBundle.movieDuration.toString()
            binding.movieRelease.text = movieBundle.yearOfRelease.toString()
            binding.movieDescription.text = movieDTO.overview

            Picasso.get().load(movieBundle.poster).into(poster)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}