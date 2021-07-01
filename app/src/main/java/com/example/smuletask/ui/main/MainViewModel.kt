package com.example.smuletask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    //Country country;

    val _listOfCountries = MutableLiveData<List<Country>>()
    val listOfCountries : LiveData<List<Country>>
        get() {
            return _listOfCountries
        }

    fun getCountries()
    {
        retrofitCountries.getCountriesService().listCountries("Bulgaria")
            .enqueue(object : Callback<List<Country>>{
                override fun onResponse(
                    call: Call<List<Country>>,
                    response: Response<List<Country>>
                ) {
                    _listOfCountries.value = response.body()
                }

                override fun onFailure(call: Call<List<Country>>, t: Throwable) {

                }
            })
    }

}