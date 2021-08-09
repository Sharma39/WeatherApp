package com.example.weather_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.weather_api.adapter.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainViewPagerAdapter(supportFragmentManager)
        main_viewpager.adapter = adapter


        //View Pager
        with(main_viewpager) {
            main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    //Do nothing...
                }

                override fun onPageSelected(position: Int) {
                    //Do nothing
                }

                override fun onPageScrollStateChanged(state: Int) {
                    //Do nothing
                }
            })
        }
    }
}
