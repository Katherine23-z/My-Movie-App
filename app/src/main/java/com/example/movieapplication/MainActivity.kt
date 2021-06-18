package com.example.movieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.movieapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = Movie("Seven", "thriller, detective", 1995, 127)
        val movie1 = Repository.getMovie(1)
        val movie2 = movie1.copy("Hidden")

        val buttonFav = binding.buttonFavourite
        buttonFav.setOnClickListener {
            Toast.makeText(applicationContext, "Add to Favourite", Toast.LENGTH_SHORT).show()
        }

        val title = binding.movieTitle
        val genre = binding.movieGenre
        val year = binding.yearOfRelease
        val timer =  binding.movieDuration
        title.setText(movie.movieTitle)
        genre.setText(movie.movieGenre)
        year.setText(movie.yearOfRelease.toString())
        timer.setText(movie.movieDuration.toString())

        val title1 = binding.movieTitle1
        val genre1 = binding.movieGenre1
        val year1 = binding.yearOfRelease1
        val timer1 =  binding.movieDuration1
        title1.setText(movie2.movieTitle)
        genre1.setText(movie2.movieGenre)
        year1.setText(movie2.yearOfRelease.toString())
        timer1.setText(movie2.movieDuration.toString())

        val movieList = Repository.getMovieList()
        for (movie in movieList){
           Log.d("MovieTitle", movie.movieTitle)
        }
    }


}