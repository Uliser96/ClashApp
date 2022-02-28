package com.aptivist.clashapp.presentation.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aptivist.clashapp.data.remote.models.AllCardsListResponse
import com.aptivist.clashapp.databinding.CardRowBinding
import com.squareup.picasso.Picasso

class AllCardsAdapter(
    private val onWeatherClicked: ((AllCardsListResponse) -> Unit)
) : androidx.recyclerview.widget.ListAdapter<AllCardsListResponse, AllCardsAdapter.AllCardsViewHolder>(WeatherDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCardsViewHolder =
        AllCardsViewHolder(
            CardRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: AllCardsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class AllCardsViewHolder(private val itemBinding: CardRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(card: AllCardsListResponse) {
            itemBinding.txtCardName.text = card.name
            Picasso.get().load(card.iconUrls.medium).into(itemBinding.imgCard)
            itemBinding.txtMaxLevel.text = card.maxLevel.toString()
            itemBinding.root.setOnClickListener {
                onWeatherClicked(card)
            }
        }
    }
}

class WeatherDiff : DiffUtil.ItemCallback<AllCardsListResponse>() {
    override fun areItemsTheSame(oldItem: AllCardsListResponse, newItem: AllCardsListResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AllCardsListResponse, newItem: AllCardsListResponse): Boolean {
        return oldItem == newItem
    }
}