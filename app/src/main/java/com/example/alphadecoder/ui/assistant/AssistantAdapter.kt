package com.example.alphadecoder.ui.assistant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alphadecoder.AssistantAction
import com.example.alphadecoder.databinding.*
import com.example.alphadecoder.ui.apps.ApplicationAdapter
import com.google.android.material.chip.Chip

class AssistantAdapter(
    private val actions: ArrayList<AssistantAction>, private val chipClick: (String) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_USER_MESSAGE = 0
    private val VIEW_TYPE_ASSISTANT_MESSAGE = 1
    private val VIEW_TYPE_FEATURE_LIST = 2
    private val VIEW_TYPE_APP_DETAILS = 3
    private val VIEW_TYPE_CATEGORY_SEARCH = 4

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_USER_MESSAGE -> {
                return UserMessageViewHolder(
                    ItemMessageUserBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            VIEW_TYPE_FEATURE_LIST -> {
                return FeatureGroupViewHolder(
                    ItemFeatureChipsBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    ), chipClick
                )
            }
            VIEW_TYPE_APP_DETAILS -> {
                return AppSearchViewHolder(
                    ItemAppDetailsMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    {}
                )
            }
            VIEW_TYPE_CATEGORY_SEARCH -> {
                return CategoryViewHolder(
                    ItemCateoryCollectionBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else ->
                return AssistantMessageViewHolder(
                    ItemMessageAssistantBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AssistantMessageViewHolder -> holder.bind(actions[position])
            is UserMessageViewHolder -> holder.bind(actions[position])
            is FeatureGroupViewHolder -> holder.bind(actions[position])
            is AppSearchViewHolder -> holder.bind(actions[position])
            is CategoryViewHolder -> holder.bind(actions[position])
        }
    }

    override fun getItemCount(): Int {
        return actions.size
    }

    fun addData(data: List<AssistantAction>) {
        actions.addAll(data)
        notifyItemInserted(actions.size - data.size)
    }

    fun addData(data: AssistantAction) {
        actions.add(data)
        notifyItemInserted(actions.size - 1)
    }

    override fun getItemViewType(position: Int): Int {
        return actions[position].type
    }

    class AssistantMessageViewHolder(private val binding: ItemMessageAssistantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chatMessage: AssistantAction) {
            binding.userMessageTV.text = chatMessage.message
        }
    }

    class UserMessageViewHolder(private val binding: ItemMessageUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chatMessage: AssistantAction) {
            binding.userMessageTV.text = chatMessage.message
        }
    }

    class FeatureGroupViewHolder(
        private val binding: ItemFeatureChipsBinding,
        private val chipCallback: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(assistantMessage: AssistantAction) {
            assistantMessage.features.forEach { feature ->
                Chip(binding.root.context).apply {
                    text = feature
                    if (binding.chipGroup.childCount != assistantMessage.features.size)
                        binding.chipGroup.addView(this)
                    this.setOnClickListener {
                        chipCallback(feature)
                    }
                }
            }
        }
    }

    class AppSearchViewHolder(
        private val binding: ItemAppDetailsMessageBinding,
        private val callback: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AssistantAction) {
            with(binding) {
                Glide.with(root.context).load(data.appDetails?.image).into(appIV)
                appTV.text = data.appDetails?.name
                appSizeTV.text = "23MB"
                data.collection?.let {
                    apps.adapter = ApplicationAdapter(it.apps, true)
                }
            }
        }
    }

    class CategoryViewHolder(private val binding: ItemCateoryCollectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AssistantAction) {
            data.collection?.let {
                if (it.title.isEmpty())
                    binding.collectionHeadTV.visibility = View.GONE else
                    binding.collectionHeadTV.text = it.title
                binding.apps.adapter = ApplicationAdapter(it.apps, true)
            }
        }
    }

    /*class UnusedAppsCollection(private val binding : ItemSmallAppRemoveBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : AssistantAction){
            data.collection?.let {
                binding.
            }
        }
    }*/

}