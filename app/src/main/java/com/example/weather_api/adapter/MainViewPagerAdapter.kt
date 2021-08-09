package com.example.weather_api.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.weather_api.fragment.RadarFragment
import com.example.weather_api.fragment.WeatherFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> WeatherFragment()
            else -> RadarFragment()
        }
    }
}