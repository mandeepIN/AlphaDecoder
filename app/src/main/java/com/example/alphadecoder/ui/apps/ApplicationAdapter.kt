package com.example.alphadecoder.ui.apps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.databinding.ItemApplicationBinding

class ApplicationAdapter(private val applications: List<AppDetails>) :
    RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationViewHolder {
        return ApplicationViewHolder(ItemApplicationBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ApplicationViewHolder, position: Int) {
        holder.bind(applications[position])
    }

    override fun getItemCount(): Int {
        return applications.size
    }

    class ApplicationViewHolder(val binding: ItemApplicationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppDetails) {
            binding.appTV.text = app.name
            Glide.with(binding.root.context).load(app.image).into(binding.appIV)
        }
    }


}