package com.aptivist.clashapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aptivist.clashapp.data.remote.models.AllCardsListResponse
import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.databinding.ActivityMainBinding
import com.aptivist.clashapp.presentation.features.AllCardsAdapter
import com.aptivist.clashapp.presentation.features.AllCardsViewModel
import com.aptivist.clashapp.presentation.features.RequestViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<AllCardsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        var adapter = AllCardsAdapter(::onCardItemClicked)
        binding.rcyCards.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel.data.observe(this) { result ->
            when(result){
                is RequestViewState.Success -> {
                    adapter.submitList(result.data.items.toList())
                    binding.rcyCards.adapter = adapter
                }
                is RequestViewState.Error -> {
                    Toast.makeText(
                        this,
                        result.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is RequestViewState.Loading -> {
                    if (result.isLoading){
                        binding.PgrBar.visibility = View.VISIBLE
                    }else{
                        binding.PgrBar.visibility = View.GONE
                    }
                }
            }
        }
        viewModel.getAllCards()
    }

    private fun onCardItemClicked(card: AllCardsListResponse) {
        Toast.makeText(
            this,
            card.name,
            Toast.LENGTH_SHORT
        ).show()
    }
}