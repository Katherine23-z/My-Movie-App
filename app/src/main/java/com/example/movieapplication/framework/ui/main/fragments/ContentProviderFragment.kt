package com.example.movieapplication.framework.ui.main.fragments

import android.app.AlertDialog
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentContentProviderBinding


const val REQUEST_CODE = 42
class ContentProviderFragment : Fragment() {

    private var _binding : FragmentContentProviderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       _binding = FragmentContentProviderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkPermission() {
        context?.let {
            when {
                ContextCompat.checkSelfPermission(it, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED -> {
                    getContacts()
            }
            shouldShowRequestPermissionRationale(android.Manifest.permission.READ_CONTACTS) -> {
                AlertDialog.Builder(it).setTitle("").setMessage("").setPositiveButton(""){
                    _, _ -> requestPermission()
                }.setNegativeButton(""){dialog, _ -> dialog.dismiss()}.create().show()
        } else -> {requestPermission()}
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    getContacts()
                }else{
                     context?.let {
                         AlertDialog.Builder(it).setTitle("").setMessage("").setNegativeButton(""){
                             dialog, _ ->  dialog.dismiss()
                         }.create().show()
                     }
                }
                return
            }
        }
    }

    private fun requestPermission() {
        requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS), REQUEST_CODE )
    }

    private fun getContacts(){
        context?.let{
            val contentResolver:ContentResolver = it.contentResolver
            val cursorWithContacts : Cursor? = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC")
            cursorWithContacts?.let { cursor ->
                for (i in 0..cursor.count){
                    if(cursor.moveToPosition(i)){
                        val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        addView(it, name)
                    }
                }
            }
            cursorWithContacts?.close()
        }
    }

    private fun addView(context: Context, textToShow: String){
        binding.containerForContacts.addView(AppCompatTextView(context).apply{
            text = textToShow
            textSize = resources.getDimension(R.dimen.text_size)
        })
    }

    companion object{
        fun newInstance() = ContentProviderFragment()
    }
}