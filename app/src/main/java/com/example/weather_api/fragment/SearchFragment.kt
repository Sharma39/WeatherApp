package com.example.weather_api.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.geoloacationfinder.viewmodel.WeatherViewModel
import com.example.weather_api.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_weather.*


class SearchFragment : Fragment()  {

//    private val searchAdapter = SearchAdapter(private var a: City)
    private val vsModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_view.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frame, WeatherFragment())
                ?.commit()
        }

        search_icon.setOnClickListener{
            var cty: String = search_edit.text.toString().trim()
            vsModel.getCity(cty)
        }



        vsModel.liveData.observe(viewLifecycleOwner, { list ->
            //list is null as it is getting no response here.
            text_we.text = list[0].name
            })


        //recycler Adapter
//        search_recyclerview.adapter = searchAdapter



    }

}