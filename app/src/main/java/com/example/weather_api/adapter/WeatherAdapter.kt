//package com.example.weather_api.adapter
//
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.weather_api.R
//import com.example.weather_api.model.City
//import kotlinx.android.synthetic.main.search_item_layout.view.*
//
//class WeatherAdapter(private var pList: List<City>):
//    RecyclerView.Adapter<WeatherAdapter.SearchViewHolder>() {
//
//    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//
//    fun updateSearch(nList: City) {
//        this.pList = nList
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(
//            R.layout.search_item_layout, parent, false
//        )
//        return SearchViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
//        pList.let {
//            holder.itemView.apply {
//                Log.d("TAG_A", it.name)
//                name_textview.text = it.name
//
//            }
////            Glide.with(holder.itemView)
////                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
////                .load(it.urlToImage)
////                .into(holder.itemView.pp_image_view)
//        }
//
//    }
//
//    override fun getItemCount(): Int = 1
//}