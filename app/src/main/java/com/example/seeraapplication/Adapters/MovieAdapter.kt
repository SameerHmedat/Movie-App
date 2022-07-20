package com.example.seeraapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.popular_movie_item_row.view.*

class MovieAdapter (private val movies:List<Movie>)
    :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private lateinit var mListener:OnItemClickListener

    interface  OnItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_item_row,
            parent,false)
        return MovieViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(view:View, mListener: OnItemClickListener):RecyclerView.ViewHolder(view){
        private val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie){
//            itemView.txtTitleDetail.text=movie.title
//            itemView.txtRating.text=movie.vote_average
//            itemView.txtParagraph.text=movie.overview
            Glide.with(itemView).load(IMAGE_BASE+movie.poster).into(itemView.img_movie)
        }
        init {
            itemView.img_movie.setOnClickListener {
                mListener.onItemClick(adapterPosition)
            }}

    }

}

