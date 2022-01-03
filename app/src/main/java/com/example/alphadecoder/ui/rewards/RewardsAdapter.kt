package com.example.alphadecoder.ui.rewards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.databinding.ItemRewardBinding

class RewardsAdapter(
    private val rewards: List<AppDetails>,
    private val clicklistener: (AppDetails) -> Unit
) :
    RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsViewHolder {
        return RewardsViewHolder(
            ItemRewardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), clicklistener
        )
    }

    override fun onBindViewHolder(holder: RewardsViewHolder, position: Int) {
        holder.bind(rewards[position])
    }

    override fun getItemCount(): Int {
        return rewards.size
    }

    class RewardsViewHolder(
        private val binding: ItemRewardBinding,
        private val clickListener: (AppDetails) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(application: AppDetails) {
            Glide.with(binding.root.context).load(application.image).into(binding.rewardIV)
            binding.rewardIV.setOnClickListener {
                clickListener(application)
            }
        }
    }

}