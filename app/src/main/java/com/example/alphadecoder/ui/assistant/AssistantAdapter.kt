package com.example.alphadecoder.ui.assistant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alphadecoder.AssistantAction
import com.example.alphadecoder.databinding.ItemFeatureChipsBinding
import com.example.alphadecoder.databinding.ItemMessageAssistantBinding
import com.example.alphadecoder.databinding.ItemMessageUserBinding
import com.google.android.material.chip.Chip

class AssistantAdapter(
    private val actions: List<AssistantAction>, private val chipClick: (String) -> Unit
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
            VIEW_TYPE_ASSISTANT_MESSAGE -> {
                return AssistantMessageViewHolder(
                    ItemMessageAssistantBinding.inflate(
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
        }
        return FeatureGroupViewHolder(
            ItemFeatureChipsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            ), chipClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AssistantMessageViewHolder -> holder.bind(actions[position])
            is UserMessageViewHolder -> holder.bind(actions[position])
            is FeatureGroupViewHolder -> holder.bind(actions[position])
        }
    }

    override fun getItemCount(): Int {
        return actions.size
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
                    binding.chipGroup.addView(this)
                    this.setOnClickListener {
                        chipCallback(feature)
                    }
                }
            }
        }
    }
}