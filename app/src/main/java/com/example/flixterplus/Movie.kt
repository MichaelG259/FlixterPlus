package com.example.flixterplus

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class MovieResponse(
    @SerialName("results")
    val data: List<Movie>?
)

@Keep
@Serializable
data class Movie(
    @SerialName("poster_path")
    val imageUrl: String?,
    @SerialName("first_air_date")
    val firstairdate: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("popularity")
    val popularity: Float?,
) : java.io.Serializable
