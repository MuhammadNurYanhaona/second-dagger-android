package com.example.dagger2.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(): ViewModel() {

    companion object {
        private const val TAG = "AuthViewModel"
    }
    
    init {
        Log.d(TAG, "AuthViewModel: view model is working.")
    }
}