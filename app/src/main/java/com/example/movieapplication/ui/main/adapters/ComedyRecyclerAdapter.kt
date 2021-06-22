package com.example.movieapplication.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.model.Movie
import com.example.movieapplication.R

class ComedyRecyclerAdapter(private  val movies: List<Movie>) : RecyclerView.Adapter<ComedyRecyclerAdapter.ComedyViewHolder>() {

    class ComedyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var title: TextView? = null
        var genre: TextView? = null
        var year: TextView? = null
        var duration: TextView? = null
        var image: ImageView? = null

        init {
            title = itemView.findViewById(R.id.caption)
            genre = itemView.findViewById(R.id.genre)
            year = itemView.findViewById(R.id.year)
            duration = itemView.findViewById(R.id.timing)
            image = itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComedyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ComedyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ComedyViewHolder, position: Int) {
        holder.title?.text = movies[position].movieTitle
        holder.genre?.text = movies[position].movieGenre
        holder.year?.text = movies[position].yearOfRelease.toString()
        holder.duration?.text = movies[position].movieDuration.toString()
        holder.image?.setImageResource(R.drawable.cosmos)
    }
}