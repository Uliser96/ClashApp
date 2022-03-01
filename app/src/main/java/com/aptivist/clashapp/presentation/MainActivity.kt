package com.aptivist.clashapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aptivist.clashapp.R
import com.aptivist.clashapp.data.remote.models.AllCardsListResponse
import com.aptivist.clashapp.databinding.ActivityMainBinding
import com.aptivist.clashapp.presentation.features.allcards.AllCardsAdapter
import com.aptivist.clashapp.presentation.features.allcards.AllCardsFragment
import com.aptivist.clashapp.presentation.features.allcards.AllCardsViewModel
import com.aptivist.clashapp.presentation.features.allcards.RequestViewState
import com.aptivist.clashapp.presentation.features.profile.ProfileFragment
import com.aptivist.clashapp.presentation.features.profile.ProfileHomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        changeFragment(ProfileHomeFragment())
        binding.apply {
            btnNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.ic_home->{
                        changeFragment(ProfileHomeFragment())
                    }
                    R.id.ic_cards -> {
                        changeFragment(AllCardsFragment())
                    }
                }
                false
            }
        }

    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FrameContainer, fragment)
            commit()
        }
    }
}