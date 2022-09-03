package com.example.seeraapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popular_movie_item_row.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvPopular.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvPopular.setHasFixedSize(true)
        getMoviePopular { movies:List<Movie> ->
            val adapterPopular=MovieAdapter(movies)
            rvPopular.adapter= adapterPopular

            adapterPopular.setOnItemClickListener(object :MovieAdapter.OnItemClickListener {
                    override fun onItemClick(position: Int) {

                        val intent= Intent(this@MainActivity,DetailsActivity::class.java)
                        intent.putExtra("poster",IMAGE_BASE+movies[position].poster)
                        intent.putExtra("MovieName",movies[position].title)
                        intent.putExtra("MovieRating",movies[position].vote_average)
                        intent.putExtra("MovieParagraph",movies[position].overview)
                        startActivity(intent)
                    } } )
        }

        rvTopRated.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvTopRated.setHasFixedSize(true)
        getMovieDataTop { movies:List<Movie> ->
            val adapterTopRated=MovieAdapter(movies)
            rvTopRated.adapter= adapterTopRated

            adapterTopRated.setOnItemClickListener(object :MovieAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {

                    val intent= Intent(this@MainActivity,DetailsActivity::class.java)
                    intent.putExtra("poster",IMAGE_BASE+movies[position].poster)
                    intent.putExtra("MovieName",movies[position].title)
                    intent.putExtra("MovieRating",movies[position].vote_average)
                    intent.putExtra("MovieParagraph",movies[position].overview)
                    startActivity(intent)
                } } )
        }

        rvRevenue.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        rvRevenue.setHasFixedSize(true)
        getMovieDataUpComing { movies:List<Movie> ->
            val adapterRevenue=MovieAdapter(movies)
            rvRevenue.adapter= adapterRevenue

            adapterRevenue.setOnItemClickListener(object :MovieAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {

                    val intent= Intent(this@MainActivity,DetailsActivity::class.java)
                    intent.putExtra("poster",IMAGE_BASE+movies[position].poster)
                    intent.putExtra("MovieName",movies[position].title)
                    intent.putExtra("MovieRating",movies[position].vote_average)
                    intent.putExtra("MovieParagraph",movies[position].overview)
                    startActivity(intent)
                } } )

        }


    }

    private fun getMoviePopular(callback: (List<Movie>)-> Unit){
        val apiService=MovieApiService.getInstance().create(MovieApiInterfacePopular::class.java)
        apiService.getMovieList().enqueue(object :Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun getMovieDataTop(callback: (List<Movie>)-> Unit){
        val apiService=MovieApiService.getInstance().create(MovieApiInterfaceTopRated::class.java)
        apiService.getMovieList().enqueue(object :Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataUpComing(callback: (List<Movie>)-> Unit){
        val apiService=MovieApiService.getInstance().create(MovieApiInterfaceUpcoming::class.java)
        apiService.getMovieList().enqueue(object :Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


}