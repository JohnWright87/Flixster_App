package com.example.flixster_app


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesRecyclerViewAdapter(private val movieList: List<Movie>
): RecyclerView.Adapter<MoviesRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.posterImageView)
        val movieTitle: TextView = itemView.findViewById(R.id.titleTextView)
        val movieDescription: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]

        holder.movieTitle.text = movie.title
        holder.movieDescription.text = movie.description

        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
            .placeholder(R.drawable.ic_launcher_background)
            .centerInside()
            .into(holder.movieImage)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}