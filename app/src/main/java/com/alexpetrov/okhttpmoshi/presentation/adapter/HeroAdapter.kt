package com.alexpetrov.okhttpmoshi.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexpetrov.okhttpmoshi.R
import com.alexpetrov.okhttpmoshi.data.model.HeroModel
import com.alexpetrov.okhttpmoshi.databinding.HeroyItemBinding
import com.alexpetrov.okhttpmoshi.presentation.interfaces.Listener
import com.squareup.picasso.Picasso

class HeroAdapter(
     private val listener: Listener, private var names: List<HeroModel> = arrayListOf()
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    private val baseURL = "https://akabab.github.io/superhero-api/api"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.heroy_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.binding.textName.text = names[position].name
        Picasso.get().load(baseURL).into(holder.binding.imageIcon)
        holder.binding.buttonHero.setOnClickListener{
            listener.onClickItem(names,position)
        }
    }

    override fun getItemCount(): Int = names.size

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = HeroyItemBinding.bind(itemView)

    }

}
