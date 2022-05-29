package com.alexpetrov.superheroes.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexpetrov.superheroes.databinding.ActivitySecondBinding
import com.alexpetrov.superheroes.presentation.activity.MainActivity.Companion.movieInfo
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        refreshActivity()
    }

    private fun refreshActivity() = with(binding) {

        val count = intent.getIntExtra("id", 0)
        val baseURl = "https://www.simplifiedcoding.net/demos/${movieInfo[count].imageurl}"

        nameHero.text = movieInfo[count].name
        realName.text = movieInfo[count].realname.toString()
        team.text = movieInfo[count].team.toString()
        year.text = movieInfo[count].firstapperance.toString()
        producer.text = movieInfo[count].createdby.toString()
        publisher.text = movieInfo[count].publisher.toString()
        bio.text = movieInfo[count].bio.toString()

        Picasso.get()
            .load(baseURl)
            .into(binding.imageView)
    }
}
