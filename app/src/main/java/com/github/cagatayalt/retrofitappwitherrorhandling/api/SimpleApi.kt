package com.github.cagatayalt.retrofitappwitherrorhandling.api

import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    /* OLD VERSIONS
    @GET("posts/1")
    suspend fun getPost(): Post // This function is suspend as we will use coroutines.

    @GET("psts/1")
    suspend fun getPost(): Response<Post>

    The endpoint is wrong so we wrote this to handle whether the response is successful or not
    Therefore the return type is changed from Post to Response<Post>
     */
    @GET("posts/1")
    suspend fun getPost(): Response<Post>
    // To get  https://BASE_URL/posts/1
    // Ex: https://jsonplaceholder.typicode.com/posts/1

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number : Int
    ) : Response<Post>
    // To get https://BASE_URL/posts/postNumber
    // Ex: https://jsonplaceholder.typicode.com/posts/4
    // So @Path generates ' /something '

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int
    ) : Response<List<Post>>
    // To get https://BASE_URL/posts?postId=userId
    // Ex: https://jsonplaceholder.typicode.com/posts?userId=3
    // So @Query generates ' ?something=someOtherThing


    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ) : Response<List<Post>>

    // multiple custom queries: sort and order



    @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap_desc")
    suspend fun getCryptoData() : ArrayList<CryptoItem>

}