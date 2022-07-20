package com.example.seeraapplication

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterfacePopular {

    @GET("/3/discover/movie?api_key=114fe6670282f6a632638661e5e86dee")
    fun getMovieList():Call<MovieResponse>
}

interface MovieApiInterfaceTopRated {

    @GET("/3/movie/top_rated?api_key=114fe6670282f6a632638661e5e86dee")
    fun getMovieList():Call<MovieResponse>
}


interface MovieApiInterfaceUpcoming {

    @GET("/3/movie/upcoming?api_key=114fe6670282f6a632638661e5e86dee")
    fun getMovieList():Call<MovieResponse>
}
