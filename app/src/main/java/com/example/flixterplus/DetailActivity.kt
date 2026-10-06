package com.example.flixterplus

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "MovieDetailActivity"
const val MOVIE_EXTRA = "MOVIE_EXTRA"

class DetailActivity : AppCompatActivity() {
    private lateinit var movieNameTV: TextView
    private lateinit var movieDescriptionTV: TextView
    private lateinit var movieImageIV: ImageView

    private lateinit var movieAirDateTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movieNameTV = findViewById(R.id.movieName)
        movieDescriptionTV = findViewById(R.id.movieDescription)
        movieAirDateTV = findViewById(R.id.movieLocation)
        movieImageIV = findViewById(R.id.movieImage)


        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie


        movieNameTV.text = movie.name

        movieDescriptionTV.text = movie.overview

        movieAirDateTV.text = "First aired: " + movie.firstairdate + ", Popularity: " + movie.popularity.toString()


        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.imageUrl)
            .into(movieImageIV)

    }
}
