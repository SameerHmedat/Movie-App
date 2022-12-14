package com.example.seeraapplication

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Constructor

@Parcelize
data class Movie(
    @SerializedName("id")
    val id:String?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("poster_path")
    val poster:String?,

    @SerializedName("release_date")
    val release:String?,


    @SerializedName("overview")
    val overview:String?,


    @SerializedName("vote_count")
    val vote_count:String?,


    @SerializedName("vote_average")
    val vote_average:String?,


    ):Parcelable{
    constructor():this(
        "",
        "",
        "",
        "",
        ",",
        ",",
        ""
    )
}
