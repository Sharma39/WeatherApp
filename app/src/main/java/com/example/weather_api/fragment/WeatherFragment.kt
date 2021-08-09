package com.example.weather_api.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather_api.R
import kotlinx.android.synthetic.main.fragment_weather.*


class WeatherFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_we.setOnClickListener {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                    ?.addToBackStack(SearchFragment().tag)
                    ?.replace(R.id.main_frame, SearchFragment())
                    ?.commit()
        }

    }


}