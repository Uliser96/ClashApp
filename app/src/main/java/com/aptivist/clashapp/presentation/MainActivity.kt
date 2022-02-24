package com.aptivist.clashapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.aptivist.clashapp.databinding.ActivityMainBinding
import com.aptivist.clashapp.presentation.features.AllCardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<AllCardsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        viewModel.data.observe(this){ result ->
            Toast.makeText(
                this,
                result.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
        viewModel.getAllCards()
    }
}