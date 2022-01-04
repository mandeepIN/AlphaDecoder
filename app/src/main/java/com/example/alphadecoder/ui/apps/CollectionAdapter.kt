package com.example.alphadecoder.ui.apps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alphadecoder.Collection
import com.example.alphadecoder.databinding.ItemCollectionBinding

class CollectionAdapter(private val collection: List<Collection>) :
    RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        return CollectionViewHolder(ItemCollectionBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    class CollectionViewHolder(val binding: ItemCollectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(collection: Collection) {
            binding.collectionHeadTV.text = collection.title
            binding.collectionRV.adapter = ApplicationAdapter(collection.apps , false)
        }

    }

}