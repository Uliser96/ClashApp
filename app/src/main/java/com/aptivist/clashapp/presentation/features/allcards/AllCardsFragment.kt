package com.aptivist.clashapp.presentation.features.allcards

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aptivist.clashapp.R
import com.aptivist.clashapp.data.remote.models.AllCardsListResponse
import com.aptivist.clashapp.databinding.FragmentAllCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllCardsFragment : Fragment() {
    private lateinit var binding: FragmentAllCardsBinding
    private val viewModel by viewModels<AllCardsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllCardsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
    private fun setupView() {
        var adapter = AllCardsAdapter(::onCardItemClicked)
        binding.rcyCards.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        viewModel.data.observe(viewLifecycleOwner) { result ->
            when(result){
                is RequestViewState.Success -> {
                    adapter.submitList(result.data.items.toList())
                    binding.rcyCards.adapter = adapter
                }
                is RequestViewState.Error -> {
                    Toast.makeText(
                        context,
                        result.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        viewModel.getAllCards()
    }

    private fun onCardItemClicked(card: AllCardsListResponse) {
        Toast.makeText(
            context,
            card.name,
            Toast.LENGTH_SHORT
        ).show()
    }

}