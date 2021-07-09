package com.example.movieapplication.framework.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.model.Movie
import com.example.movieapplication.R
import com.example.movieapplication.model.getThrillerMovies
import com.example.movieapplication.framework.ui.main.MainFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class ThrillerRecyclerAdapter(private var onItemViewClickListener: MainFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<ThrillerRecyclerAdapter.ThrillerViewHolder>() {

    private val thrillerMovies: MutableList<Movie> = getThrillerMovies()

    inner class ThrillerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.apply {
                findViewById<TextView>(R.id.caption).text = movie.movieTitle
                findViewById<TextView>(R.id.genre).text = movie.movieGenre
                findViewById<TextView>(R.id.timing).text = movie.movieDuration.toString()
                findViewById<TextView>(R.id.year).text = movie.yearOfRelease.toString()
                Picasso.get().load(movie.poster).into(imageView)
                setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(movie)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrillerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ThrillerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return thrillerMovies.size
    }

    override fun onBindViewHolder(holder: ThrillerViewHolder, position: Int) {
        holder.bind(thrillerMovies[position])

    }
}