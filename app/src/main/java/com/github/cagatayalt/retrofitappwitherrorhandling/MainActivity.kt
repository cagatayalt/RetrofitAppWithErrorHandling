package com.github.cagatayalt.retrofitappwitherrorhandling

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.cagatayalt.retrofitappwitherrorhandling.databinding.ActivityMainBinding
import com.github.cagatayalt.retrofitappwitherrorhandling.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        

        initListeners()
        
        
        
    }

    private fun initListeners() {
        binding.postBtn1.setOnClickListener {
            val myNumber = binding.mainET.text.toString()
            if (!myNumber.isEmpty()) {
                viewModel.getCustomPosts(Integer.parseInt(myNumber))
            } else {
                Toast.makeText(this,"type something",Toast.LENGTH_SHORT).show()
            }

            viewModel.myCustomPosts.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.mainTV.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response",it.myUserId.toString())
                        Log.d("Response",it.id.toString())
                        Log.d("Response",it.title)
                        Log.d("Response",it.body)
                        Log.d("Response","-------------")
                    }
                }   else {
                    binding.mainTV.text = response.code().toString()
                }
            })
        }
        binding.postBtn2.setOnClickListener {
            val myNumber = binding.mainET.text.toString()
            if (!myNumber.isNullOrEmpty()) {
                viewModel.getCustomPosts2(Integer.parseInt(myNumber),"id","desc")
                // All posts with userId = myNumber, sorted by 'id' in 'desc' ending order
                // Ex: userId = myNumber = 3
                // https://jsonplaceholder.typicode.com/posts?userId=3&_sort=id&_order=desc
            } else {
                Toast.makeText(this,"type something",Toast.LENGTH_SHORT).show()
            }

            viewModel.myCustomPosts2.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.mainTV.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response",it.myUserId.toString())
                        Log.d("Response",it.id.toString())
                        Log.d("Response",it.title)
                        Log.d("Response",it.body)
                        Log.d("Response","-------------")
                    }

                }   else {
                    binding.mainTV.text = response.code().toString()
                }
            })

        }
        binding.postBtn3.setOnClickListener {
            val options: HashMap<String,String> = HashMap()
            options.put("_sort","id")
            // Or, simply write options["_sort"] = "id"
            options["_order"] = "desc"
            val myNumber = binding.mainET.text.toString()
            if (myNumber.isNotEmpty()) {
                viewModel.getCustomPosts3(Integer.parseInt(myNumber),options)
            } else {
                Toast.makeText(this,"type something",Toast.LENGTH_SHORT).show()
            }

            viewModel.myCustomPosts3.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.mainTV.text = response.body().toString()
                } else {
                    binding.mainTV.text = response.code().toString()
                }
            })
        }    }
}