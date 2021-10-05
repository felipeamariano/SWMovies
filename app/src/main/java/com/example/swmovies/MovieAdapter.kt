package com.example.swmovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.swmovies.model.Movies

class MovieAdapter(
    private val context: Context,
    private val movieList: List<Movies>): RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false))


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
       holder.movieName.text = item.title
        Glide.with(context).load("https://image.tmdb.org/t/p/original/" + item.poster).into(holder.movieImage)

    }

    override fun getItemCount(): Int = movieList.size

}

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val movieImage: ImageView = itemView.findViewById(R.id.mov_image)
    val movieName: TextView = itemView.findViewById(R.id.mov_name)

}