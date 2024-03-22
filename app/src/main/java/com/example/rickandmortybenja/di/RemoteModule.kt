package com.example.rickandmortybenja.di

import com.example.rickandmortybenja.data.source.remote.ApiRickAndMorty
import com.example.rickandmortybenja.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideApiRickAndMorty(): ApiRickAndMorty {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRickAndMorty::class.java)
    }

}