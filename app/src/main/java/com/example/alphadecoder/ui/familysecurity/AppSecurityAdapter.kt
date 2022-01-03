package com.example.alphadecoder.ui.familysecurity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.databinding.ItemAppUninstallBinding

class AppSecurityAdapter(private val apps: List<AppDetails>) :
    RecyclerView.Adapter<AppSecurityAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(
            ItemAppUninstallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount(): Int {
        return apps.size
    }

    class AppViewHolder(val binding: ItemAppUninstallBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(app: AppDetails) {
            binding.appTV.text = app.name
            Glide.with(binding.root.context).load(app.image).into(binding.appIV)
        }
    }
}