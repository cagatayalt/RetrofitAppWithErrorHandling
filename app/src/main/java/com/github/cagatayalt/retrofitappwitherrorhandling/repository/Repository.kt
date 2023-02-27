package com.github.cagatayalt.retrofitappwitherrorhandling.repository


import com.github.cagatayalt.retrofitappwitherrorhandling.api.RetrofitInstance
import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }


    suspend fun getCustomPosts(userId: Int) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId)
    }

    suspend fun getCustomPosts2(userId: Int, sort: String, order: String) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts2(userId,sort,order)
    }

    suspend fun getCryptoData() : ArrayList<CryptoItem> {
        return RetrofitInstance.cryptoApi.getCryptoData()
    }
}