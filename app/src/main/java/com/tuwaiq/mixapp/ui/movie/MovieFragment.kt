package com.tuwaiq.mixapp.ui.movie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tuwaiq.mixapp.R
import com.tuwaiq.mixapp.imdb.models.Movie

class MovieFragment : Fragment() {

    private lateinit var moviesRv:RecyclerView

    private  val viewModel by lazy { ViewModelProvider(this)[MovieViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie_fragment, container, false)
        return view
    }


    private inner class MoviesHolder(view: View):
        RecyclerView.ViewHolder(view){


    }

    private inner class MoviesAdapter(val movies:List<Movie>):
        RecyclerView.Adapter<MoviesHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
            val view = layoutInflater.inflate(
                R.layout.movie_list_item,
                parent,
                false
            )

            return MoviesHolder(view)
        }

        override fun onBindViewHolder(holder: MoviesHolder, position: Int) {

        }

        override fun getItemCount(): Int = movies.size
    }
}