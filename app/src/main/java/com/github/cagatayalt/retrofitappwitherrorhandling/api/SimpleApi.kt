package com.github.cagatayalt.retrofitappwitherrorhandling.api

import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    /* OLD VERSION
    @GET("posts/1")
    suspend fun getPost(): Post // This function is suspend as we will use coroutines.
     */

    @GET("psts/1")
    suspend fun getPost(): Response<Post>

    @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap_desc")
    suspend fun getCryptoData() : ArrayList<CryptoItem>

}