package com.example.movieapplication.framework.ui.main.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentSettingsBinding

 const val IS_ADULT = "Adult"
const val MY_SETTINGS = "My settings"
class SettingsFragment : Fragment() {
    private var isDataSetAdult: Boolean = false

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val sharedPrefs = activity?.getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE)
        val text = binding.textSettings
        val switch = binding.switch1
        sharedPrefs?.getBoolean(IS_ADULT, false)?.let { switch.setChecked(it) }
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                val editor = sharedPrefs?.edit()
                editor?.putBoolean(IS_ADULT, true)?.apply()
                text.text = getString(R.string.on)
            } else {
                val editor = sharedPrefs?.edit()
                editor?.putBoolean(IS_ADULT, false)?.apply()
                text.text = getString(R.string.off)
            }

        }
        return binding.root
    }


}