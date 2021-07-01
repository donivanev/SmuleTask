package com.example.smuletask.ui.main

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitCountries {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build())
        .build()

    fun getCountriesService() = retrofit.create(CountriesService::class.java)
}