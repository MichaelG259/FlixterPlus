package com.example.flixterplus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

private const val TAG = "MovieAdapter"

class MovieAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val nameTextView = itemView.findViewById<TextView>(R.id.movieName)
        private val descriptionTextView = itemView.findViewById<TextView>(R.id.movieDescription)
        //private val locationTextView = itemView.findViewById<TextView>(R.id.movieLocation)
        private val imageView = itemView.findViewById<ImageView>(R.id.movieImage)

        init {
            itemView.setOnClickListener(this)
        }


        fun bind(movie: Movie) {
            nameTextView.text = movie.name
            //descriptionTextView.text = movie.popularity.toString()

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" + movie.imageUrl)
                .into(imageView)
        }

        override fun onClick(v: View?) {
            // Get selected movie
            val movie = movies[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected movie
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }


}
