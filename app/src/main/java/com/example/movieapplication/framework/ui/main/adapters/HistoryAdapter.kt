package com.example.movieapplication.framework.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.databinding.ItemHistoryListBinding
import com.example.movieapplication.model.Movie

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.RecyclerItemViewHolder>() {
    private var data: List<Movie> = arrayListOf()

    fun setData(data: List<Movie>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder =
        RecyclerItemViewHolder(
            ItemHistoryListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )



    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    inner class RecyclerItemViewHolder(private val binding: ItemHistoryListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Movie) = with(binding){
           if (layoutPosition != RecyclerView.NO_POSITION){
               recyclerViewItem.text = String.format("%s %s %d", data.movieTitle, data.movieGenre, data.yearOfRelease)
               root.setOnClickListener {
                   Toast.makeText(itemView.context, "on click: ${data.movieTitle}", Toast.LENGTH_SHORT).show()
               }
           }
            }
        }
    }


