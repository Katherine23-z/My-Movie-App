package com.example.movieapplication.framework.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.model.Movie
import com.example.movieapplication.R
import com.example.movieapplication.model.getComedyMovies
import com.example.movieapplication.framework.ui.main.fragments.MainFragment

class ComedyRecyclerAdapter(private var onItemViewClickListener: MainFragment.OnItemViewClickListener?) : RecyclerView.Adapter<ComedyRecyclerAdapter.ComedyViewHolder>() {

    private  val comedyMovies: MutableList<Movie> = getComedyMovies()

    inner class ComedyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(movie: Movie) {
            itemView.apply {
                findViewById<TextView>(R.id.caption).text = movie.movieTitle
                findViewById<TextView>(R.id.genre).text = movie.movieGenre
                findViewById<TextView>(R.id.timing).text = movie.movieDuration.toString()
                findViewById<TextView>(R.id.year).text = movie.yearOfRelease.toString()
                findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.cosmos)
                setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(movie)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComedyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ComedyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return comedyMovies.size
    }

    override fun onBindViewHolder(holder: ComedyViewHolder, position: Int) {
        holder.bind(comedyMovies[position])
    }
}