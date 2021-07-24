package com.example.movieapplication.framework.ui

import android.app.IntentService
import android.content.Intent
import android.util.Log

private const val TAG = "MainServiceTAG"
const val MAIN_SERVICE_STRING_EXTRA = "MainServiceExtra"

class MainService(name: String = "MainService") : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent ${intent?.getStringExtra(MAIN_SERVICE_STRING_EXTRA)}")
    }
}