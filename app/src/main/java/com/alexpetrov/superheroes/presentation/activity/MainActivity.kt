package com.alexpetrov.superheroes.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexpetrov.superheroes.data.model.HeroModel
import com.alexpetrov.superheroes.databinding.ActivityMainBinding
import com.alexpetrov.superheroes.presentation.adapter.HeroAdapter
import com.alexpetrov.superheroes.presentation.interfaces.Listener

class MainActivity : AppCompatActivity(), Listener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
    }

    private fun initRecycler() = with(binding) {

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = HeroAdapter(this@MainActivity, heroInfo)
    }

    override fun onClickItem(heroModel: List<HeroModel>, position: Int) {
        val intentHero = Intent(this, SecondActivity::class.java)
        intentHero.putExtra("id",position)
        startActivity(intentHero)
    }

    companion object{

        var heroInfo = listOf<HeroModel>()
    }
}