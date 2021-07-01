package com.example.smuletask.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.smuletask.R
import kotlin.math.log

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        //viewModel.livedata.observe(this.viewLifecycleOwner, Observer { stringValue ->
            //Log.d("test", "String value: $stringValue")
        //});
        viewModel.listOfCountries.observe(this.viewLifecycleOwner, Observer { list ->
            for (l in list)
            {
                Log.i("tag", "onActivityCreated: ${l.name}")
            }
        });

        viewModel.getCountries()
        //Handler(Looper.getMainLooper()).postDelayed({
            //viewModel.func()
        //}, 3000)
    }
}