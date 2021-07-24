package com.example.movieapplication.framework.ui.main.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.*
import androidx.core.app.ActivityCompat
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentGoogleMapWrapperBinding
import com.example.movieapplication.model.Movie

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_google_map_wrapper.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.IOException


class GoogleMapFragment : Fragment(), CoroutineScope by MainScope() {


    private lateinit var binding: FragmentGoogleMapWrapperBinding
    private lateinit var map: GoogleMap
    private val markers:ArrayList<Marker> = arrayListOf()
    private lateinit var movieBundle : String
    private lateinit var movieLocation: String

    companion object {
        const val BUNDLE_EXTRA_GEO = "movieLocation"

        fun newInstance(bundle: Bundle): GoogleMapFragment {
            val fragment = GoogleMapFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isMyLocationButtonEnabled = true
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            map.isMyLocationEnabled = true
        }
        val place = LatLng(44.952117, 34.102417)
        val marker = googleMap.addMarker(MarkerOptions().position(place).title(getString(R.string.start)))
        marker?.let { markers.add(it) }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(place))
        googleMap.setOnMapLongClickListener { latLng ->
            getAddressAsync(latLng)
            setMarker(latLng, getString(R.string.new_position))
            drawLine()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentGoogleMapWrapperBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        movieBundle = arguments?.getString(BUNDLE_EXTRA_GEO) ?: String()
        movieLocation = movieBundle
        mapFragment?.getMapAsync(callback)
        initSearchByAddress()
        showMovieLocation()
    }

    private fun showMovieLocation() {
        searchMovieBtn.setOnClickListener {
            val geocoder = Geocoder(it.context)
             Thread {
                try{
                    val addresses = geocoder.getFromLocationName(movieLocation, 1)
                    if (addresses.isNotEmpty()) {
                        goToAddress(addresses, it, movieLocation)
                    }
                }catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }

    private fun getAddressAsync(location:LatLng){
        context?.let {
            val geoCoder = Geocoder(it)
            launch(Dispatchers.IO) {
                try {
                    val addresses = geoCoder.getFromLocation(location.latitude, location.longitude,1)
                    textAddress.post {
                        textAddress.text = addresses.first().getAddressLine(0)
                    }
                }catch (e: IOException){
                    e.printStackTrace()
                }
            }
        }
    }

    private fun setMarker(location: LatLng, searchText: String?) {
        val marker = map.addMarker(MarkerOptions().position(location).title(searchText))
        marker?.let { markers.add(marker) }
    }

    private fun drawLine() {
        val last: Int = markers.size - 1
        if (last >= 1){
            val previous: LatLng = markers[last - 1].position
            val currenr : LatLng = markers[last].position
            map.addPolyline(PolylineOptions().add(previous, currenr).color(Color.MAGENTA).width(5f))
        }
    }

    private fun initSearchByAddress() = with(binding) {
        buttonSearch.setOnClickListener {
            val geocoder = Geocoder(it.context)
            val searchText = searchAddress.text.toString()
            Thread {
                try{
                    val addresses = geocoder.getFromLocationName(searchText, 1)
                    if (addresses.isNotEmpty()) {
                        goToAddress(addresses, it, searchText)
                    }
                }catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }

    private fun goToAddress(addresses: MutableList<Address>, view: View, searchText: String?){
        val location = LatLng(addresses[0].latitude, addresses[0].longitude)
        view.post {
            setMarker(location, searchText)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.map_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_map_mode_normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.menu_map_mode_satellite -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
                return true
            }
            R.id.menu_map_mode_terrain -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
                return true
            }
            R.id.menu_map_traffic -> {
                map.isTrafficEnabled = !map.isTrafficEnabled
                return true
            }
        }
        return false
    }

}