package com.example.movieapplication.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.model.Movie
import com.example.movieapplication.R

class ThrillerRecyclerAdapter(private val movies: List<Movie>): RecyclerView.Adapter<ThrillerRecyclerAdapter.ThrillerViewHolder>() {

    class ThrillerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var title: TextView? = null
        var genre: TextView? = null
        var year: TextView? = null
        var duration: TextView? = null
        var image: ImageView? = null

        init{
            title = itemView.findViewById(R.id.caption)
            genre = itemView.findViewById(R.id.genre)
            year = itemView.findViewById(R.id.year)
            duration = itemView.findViewById(R.id.timing)
            image = itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrillerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ThrillerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return movies.size
    }

    override fun onBindViewHolder(holder: ThrillerViewHolder, position: Int) {
        holder.title?.text = movies[position].movieTitle
        holder.genre?.text = movies[position].movieGenre
        holder.year?.text = movies[position].yearOfRelease.toString()
        holder.duration?.text = movies[position].movieDuration.toString()
        holder.image?.setImageResource(R.drawable.cosmos)

    }
}