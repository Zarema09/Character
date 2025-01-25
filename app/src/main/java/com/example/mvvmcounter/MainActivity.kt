package com.example.mvvmcounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcounter.adapter.CharacterAdapter
import com.example.mvvmcounter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()

        viewModel.getCharacters()

        viewModel.charactersData.observe(this) { data ->

        }
    }

    private fun setupRecycler() = with(binding) {
        rvCharacters.adapter = CharacterAdapter()
        rvCharacters.layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            true
        )
    }
}