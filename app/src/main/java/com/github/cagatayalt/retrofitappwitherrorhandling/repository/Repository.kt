package com.github.cagatayalt.retrofitappwitherrorhandling.repository


import com.github.cagatayalt.retrofitappwitherrorhandling.api.RetrofitInstance
import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getCryptoData() : ArrayList<CryptoItem> {
        return RetrofitInstance.cryptoApi.getCryptoData()
    }
}