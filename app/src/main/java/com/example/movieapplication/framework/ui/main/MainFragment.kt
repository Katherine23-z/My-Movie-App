package com.example.movieapplication.framework.ui.main

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.viewmodel.AppState
import com.example.movieapplication.databinding.MainFragmentBinding
import com.example.movieapplication.model.Movie
import com.example.movieapplication.framework.ui.main.adapters.ComedyRecyclerAdapter
import com.example.movieapplication.framework.ui.main.adapters.HorrorRecyclerAdapter
import com.example.movieapplication.framework.ui.main.adapters.FantasticRecyclerAdapter
import com.example.movieapplication.framework.ui.main.adapters.ThrillerRecyclerAdapter
import com.example.movieapplication.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import android.view.Menu
import android.view.MenuItem

class MainFragment : Fragment(), CoroutineScope by MainScope(){
    companion object {
        fun newInstance() = MainFragment()
    }


    private val viewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private lateinit var navigation: Navigation
    private lateinit var mainView : LinearLayout
    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val activity : MainActivity = context as MainActivity
        navigation = activity.getNavigation()
        val isAdult = activity.getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE).getBoolean(IS_ADULT, true)
        if(isAdult){
            initRecyclers()
            initHeaders()
        }else {
            Toast.makeText(context, "ADULT", Toast.LENGTH_SHORT).show()
        }
        mainView = binding.mainView
        return view
    }

    fun initHeaders(){
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

        val serialHeader: TextView = binding.headerFantastic
        serialHeader.setOnClickListener {
            navigation.addFragment(GenreFragment.newInstance(), true)
        }
    }

    fun initRecyclers() {
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

        val fantasticRecycler: RecyclerView = binding.recyclerFantastic
        fantasticRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        fantasticRecycler.adapter = FantasticRecyclerAdapter(object : OnItemViewClickListener{
            override fun onItemViewClick(movie: Movie) {
                val bundle = Bundle()
                bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                navigation.addFragment(MovieCardFragment.newInstance(bundle), true)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer{renderData(it as AppState)})
        viewModel.getDataFromLocalSourceHorrors()
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                Snackbar.make(mainView, R.string.sucess, Snackbar.LENGTH_LONG).show()
            }
            is AppState.Loading -> {
                binding.mainFragmentLoadingLayout.visibility = View.VISIBLE
                Snackbar.make(mainView, getString(R.string.loading), Snackbar.LENGTH_LONG).show()
            }
            is AppState.Error -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                mainView.showSnackBar(getString(R.string.error), getString(R.string.reload), {viewModel.getDataFromLocalSourceHorrors()})
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
        val search: MenuItem? = menu?.findItem(R.id.action_search)
        val searchText = search?.actionView as androidx.appcompat.widget.SearchView
        searchText.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings -> navigation.addFragment(SettingsFragment.newInstance(), true)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun View.showSnackBar(
            text: String,
            actionText: String,
            action: (View) -> Unit,
            lenght: Int = Snackbar.LENGTH_INDEFINITE){
        Snackbar.make(this, text, lenght).setAction(actionText, action).show()
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }

}




