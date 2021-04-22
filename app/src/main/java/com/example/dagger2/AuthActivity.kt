package com.example.dagger2

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

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