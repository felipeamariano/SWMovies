package com.example.swmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swmovies.api.MyRetrofit
import com.example.swmovies.model.Movies
import com.example.swmovies.model.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recycleMovies: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleMovies = findViewById(R.id.recycler_movies)
        recycleMovies.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData(){
       val call: Call<ResponseData> = MyRetrofit().movieApi().getMoviesApi("ec81d5b61b6c0306b8544edf132e0690")
        call.enqueue(object : Callback<ResponseData>{
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val adapter = MovieAdapter(this@MainActivity,response.body()?.results as List<Movies>)
                recycleMovies.adapter = adapter
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

