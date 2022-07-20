package com.example.seeraapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.popular_movie_item_row.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val  bundle:Bundle?=intent.extras

        val movieImageId= bundle?.getString("poster")
        val movieNameId= bundle?.getString("MovieName")
        val movieRatingId= bundle?.getString("MovieRating")
        val movieParagraphId= bundle?.getString("MovieParagraph")

        Glide.with(this).load(movieImageId).into(img_detail)
        txtTitleDetail.text=movieNameId
        txtRating.text=movieRatingId
        txtParagraph.text=movieParagraphId

    }
}