package com.aptivist.clashapp.presentation.features.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.aptivist.clashapp.R
import com.aptivist.clashapp.databinding.FragmentProfileDetailBinding

class ProfileDetailFragment : Fragment() {
    lateinit var binding: FragmentProfileDetailBinding
    private val args by navArgs<ProfileDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.apply {
            txtPlayerName.text = args.playerInfo.name
            txtPlayerTag.text = args.playerInfo.tag
            txtLevel.text = args.playerInfo.expLevel.toString()
            txtCurrentTrophy.text = args.playerInfo.trophies.toString()
        }
    }
}