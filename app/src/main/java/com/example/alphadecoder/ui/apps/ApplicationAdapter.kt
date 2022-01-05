package com.example.alphadecoder.ui.apps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.databinding.ItemApplicationBinding
import com.example.alphadecoder.databinding.ItemSmallAppBinding

class ApplicationAdapter(
    private val applications: List<AppDetails>,
    private val isSmall: Boolean = false
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                return ApplicationViewHolder(
                    ItemApplicationBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> return SmallAppViewHolder(
                ItemSmallAppBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ApplicationViewHolder)
            holder.bind(applications[position])
        else if (holder is SmallAppViewHolder)
            holder.bind(applications[position])
    }

    override fun getItemCount(): Int {
        return applications.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isSmall)
            0 else 1
    }

    class ApplicationViewHolder(val binding: ItemApplicationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppDetails) {
            binding.appTV.text = app.name
            Glide.with(binding.root.context).load(app.image).into(binding.appIV)
        }
    }

    class SmallAppViewHolder(val binding: ItemSmallAppBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppDetails) {
            if (app.size.isNotEmpty())
                binding.appSizeTV.apply {
                    text = app.size
                    visibility = View.VISIBLE
                    binding.downloadIV.visibility = View.GONE
                }
            binding.nameTV.text = app.name
            Glide.with(binding.root.context).load(app.image).into(binding.appIV)
        }
    }


}