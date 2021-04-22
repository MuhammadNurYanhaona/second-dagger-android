package com.example.dagger2.di

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.dagger2.BaseApplication
import com.example.dagger2.R
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesString(): String { return "Say something!"}

        @JvmStatic
        @Provides
        fun getAppContext(application: BaseApplication): Context {
            return application.applicationContext
        }

        @JvmStatic
        @Provides
        fun providesRequestOptions(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.white_background)
                    .error(R.drawable.white_background)
        }

        @JvmStatic
        @Provides
        fun providesGlideInstance(application: BaseApplication,
                                  requestOptions: RequestOptions): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions);
        }

        @JvmStatic
        @Provides
        fun providesAppDrawable(application: BaseApplication): Drawable {
            return ContextCompat.getDrawable(application, R.drawable.logo)!!
        }
    }
}