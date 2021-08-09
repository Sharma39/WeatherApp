package com.example.geoloacationfinder.viewmodel



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geoloacationfinder.util.State
import com.example.weather_api.model.City
import com.example.weather_api.network.WeatherRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {


    private var netJob: Job? = null

    private val retrofit = WeatherRetrofit()

    val liveData: MutableLiveData<List<City>> = MutableLiveData()

    val statusData = MutableLiveData<State>()

    fun getCity(city: String){
        statusData.value = State.LOADING
        netJob = viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = retrofit.makeApiCallAsync(
                    city
                ).await()


                liveData.postValue(result.cities)
                statusData.postValue(State.SUCCESS)

            } catch (e: Exception) {
                //At this point an error occurred
                Log.d("TAG_E", e.message.toString())
                statusData.postValue(State.ERROR)
            }

        }

    }

    override fun onCleared() {
        netJob?.cancel()
        super.onCleared()
    }
}