package com.pratikvelani.taskly.data.di

import android.content.Context
import com.google.gson.Gson
import com.pratikvelani.taskly.data.local.SharedPrefsApi
import com.pratikvelani.taskly.data.local.SharedPrefsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideSharedPrefsApi(@ApplicationContext context: Context, gson: Gson): SharedPrefsApi {
        return SharedPrefsApiImpl(context = context, gson = gson)
    }
}
