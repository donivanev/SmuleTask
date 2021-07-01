package com.example.smuletask.ui.main

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountriesService {
    @GET("v2/name/{name}")
    fun listCountries(
        @Path ("name")
        countryName: String
    ): Call<List<Country>>

    //@GET("v2/name")
    //fun listRepos(
        //@Path ("names")
        //countryNames: List<Country>
    //): Call<List<Country>>
}