package com.alexpetrov.superheroes.presentation.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexpetrov.superheroes.data.model.Movie
import com.alexpetrov.superheroes.data.retrofit.ApiService
import com.alexpetrov.superheroes.data.retrofit.Repository
import com.alexpetrov.superheroes.databinding.ActivityMainBinding
import com.alexpetrov.superheroes.presentation.adapter.MovieAdapter
import com.alexpetrov.superheroes.domain.Listener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Listener {

    private lateinit var apiService: ApiService
    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = Repository.retrofitService
        binding.recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        getAllMovieList()
    }

    private fun getAllMovieList() {
        apiService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MovieAdapter(response.body() as MutableList<Movie>,this@MainActivity)
                adapter.notifyDataSetChanged()
                binding.recyclerView.adapter = adapter
                movieInfo = response.body()!!
            }
        })
    }

    override fun onClickItem(movie: MutableList<Movie>, position: Int) {
        val intentMovie = Intent(this, SecondActivity::class.java)
        intentMovie.putExtra("name", position)
        startActivity(intentMovie)
    }

    companion object{
        var movieInfo = listOf<Movie>()
    }
}





