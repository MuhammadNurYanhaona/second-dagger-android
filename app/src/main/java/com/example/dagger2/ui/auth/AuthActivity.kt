package com.example.dagger2.ui.auth

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.dagger2.R
import com.example.dagger2.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    @Inject
    lateinit var message: String

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this,
                providerFactory).get(AuthViewModel::class.java)

        Log.d(TAG, "onCreate: $message")
        Log.d(TAG, "onCreate: ${context.packageName}")
        setLogo()
    }

    fun setLogo() {
        requestManager.load(logo).into(findViewById<ImageView>(R.id.login_logo))
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}