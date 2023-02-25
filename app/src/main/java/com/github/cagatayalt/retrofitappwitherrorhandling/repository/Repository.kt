package com.github.cagatayalt.retrofitappwitherrorhandling.repository


import com.github.cagatayalt.retrofitappwitherrorhandling.api.RetrofitInstance
import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getCryptoData() : ArrayList<CryptoItem> {
        return RetrofitInstance.cryptoApi.getCryptoData()
    }
}