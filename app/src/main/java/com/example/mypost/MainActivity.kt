package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()
        request.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts=response.body()!!
                    Log.d("Tag",posts.toString())
                    Toast.makeText(baseContext, "fetched ${posts.size}", Toast.LENGTH_LONG)
                        .show()
                    var adapter=PostRvAdapter(baseContext,posts)
                    binding.rvPosts.adapter=adapter
                    binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)

                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })
    }
}