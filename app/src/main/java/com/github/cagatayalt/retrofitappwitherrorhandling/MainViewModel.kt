package com.github.cagatayalt.retrofitappwitherrorhandling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.github.cagatayalt.retrofitappwitherrorhandling.model.CryptoItem
import com.github.cagatayalt.retrofitappwitherrorhandling.model.Post
import com.github.cagatayalt.retrofitappwitherrorhandling.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var cryptoResponse : MutableLiveData<ArrayList<CryptoItem>> = MutableLiveData()

    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts3: MutableLiveData<Response<List<Post>>> = MutableLiveData()



    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value  = response // mutable live data object ??
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId,sort,order)
            myCustomPosts2.value = response
        }
    }

    fun getCustomPosts3(userId: Int, options: Map<String,String>) {
        viewModelScope.launch{
            val response = repository.getCustomPosts3(userId,options)
            myCustomPosts3.value = response
         }
    }



    fun getCryptoData() {
        viewModelScope.launch {
            val response = repository.getCryptoData()
            cryptoResponse.value = response
        }
    }

}