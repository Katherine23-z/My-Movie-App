package com.example.movieapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.Movie
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ItemBinding

class HorrorRecyclerAdapter( private val movies: List<Movie>) : RecyclerView.Adapter<HorrorRecyclerAdapter.HorrorsViewHolder>(){

    class HorrorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorrorsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return HorrorsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: HorrorsViewHolder, position: Int) {
        holder.title?.text = "Заголовок"
        holder.genre?.text = "Ужасы"
        holder.year?.text = ""
        holder.duration?.text = "час"
        holder.image?.setImageResource(R.drawable.cosmos)

    }

}