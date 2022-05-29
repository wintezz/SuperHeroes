package com.alexpetrov.superheroes.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexpetrov.superheroes.R
import com.alexpetrov.superheroes.data.model.Movie
import com.alexpetrov.superheroes.databinding.MovieItemBinding
import com.alexpetrov.superheroes.presentation.interfaces.Listener
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movies: MutableList<Movie>,
    private val listener: Listener
) : RecyclerView.Adapter<MovieAdapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.binding.txtName.text = movies[position].name
        holder.binding.txtTeam.text = movies[position].team
        holder.binding.producer.text = movies[position].createdby

        holder.binding.imageMovie.setOnClickListener {
            listener.onClickItem(movies, position)
        }

        Picasso.get()
            .load(movies[position].imageurl)
            .into(holder.binding.imageMovie)

    }

    override fun getItemCount(): Int = movies.size

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = MovieItemBinding.bind(itemView)
    }
}
