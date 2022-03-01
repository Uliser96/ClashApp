package com.aptivist.clashapp.presentation.features.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.aptivist.clashapp.R
import com.aptivist.clashapp.databinding.FragmentProfileBinding
import com.aptivist.clashapp.presentation.features.allcards.AllCardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
    private fun setupView() {
        binding.apply {
            btnSubmit.setOnClickListener {
                viewModel.getPlayerProfile("#"+edtPlayerTag.text.toString().trim())
            }
            viewModel.data.observe(viewLifecycleOwner){ result ->
                when(result){
                    is ProfileViewState.Loading->{
                        if (result.isLoading){
                            pgrBar.visibility = View.VISIBLE
                        }else{
                            pgrBar.visibility = View.GONE
                        }
                    }
                    is ProfileViewState.Success->{
                        val action = ProfileFragmentDirections.actionProfileFragmentToProfileDetailFragment(
                            result.data
                        )
                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
                    }
                    is  ProfileViewState.Error->{
                        Toast.makeText(
                            context,
                            result.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }
}