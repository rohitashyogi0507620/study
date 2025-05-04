package com.yogify.study.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.reflect.TypeToken
import com.yogify.study.ui.home.dataclass.BannerHomeScreenItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class HomeViewModel : ViewModel() {


    private var _bannerHomeScreen = MutableLiveData<List<BannerHomeScreenItem>>()
    val bannerHomeScreen: LiveData<List<BannerHomeScreenItem>>
        get() = _bannerHomeScreen

    init {
        loadBannerData()
    }

    private fun loadBannerData() {
        val banners = mutableListOf<BannerHomeScreenItem>(
            BannerHomeScreenItem(
                BannerUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3xTMB5yvn5uD3RUfC8Xgrdv7ZbhpjHHHdGA&s",
                MobileDeeplinkUrl = "PROMAX"
            ), BannerHomeScreenItem(
                BannerUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnFqGt2eVVxK7MNqkYyj8_rb1W_TkAPF8cyw&s",
                MobileDeeplinkUrl = "PROMAX"
            ), BannerHomeScreenItem(
                BannerUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLHnoACL-K8eTqMxkVF1-Tjga5yjrYafuD88AUH6qzcG5ZbaCd8VLcCvsHOCLL8Df2nfo&usqp=CAU",
                MobileDeeplinkUrl = "PROMAX"
            )
        )
        _bannerHomeScreen.postValue(banners)

    }


}