package com.example.alphadecoder.ui.assistant

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alphadecoder.AssistantMessage
import com.example.alphadecoder.ChatMessage
import com.example.alphadecoder.FeatureGroup
import com.example.alphadecoder.databinding.ItemFeatureChipsBinding
import com.example.alphadecoder.databinding.ItemMessageAssistantBinding
import com.example.alphadecoder.databinding.ItemMessageUserBinding

class AssistantAdapter(private val messages: List<AssistantMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_USER_MESSAGE = 0
    private val VIEW_TYPE_ASSISTANT_MESSAGE = 1
    private val VIEW_TYPE_FEATURE_LIST = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_USER_MESSAGE -> {
                return UserMessageViewHolder(Item)
            }
            VIEW_TYPE_ASSISTANT_MESSAGE -> {
                return AssistantMessageViewHolder()
            }
            VIEW_TYPE_FEATURE_LIST -> {
                return FeatureGroupViewHolder()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        when (messages[position]) {
            is ChatMessage -> {
                return VIEW_TYPE_USER_MESSAGE
            }
            is AssistantMessage -> {
                return VIEW_TYPE_ASSISTANT_MESSAGE
            }
            is FeatureGroup -> {
                return VIEW_TYPE_FEATURE_LIST
            }
        }
        return super.getItemViewType(position)
    }

    class AssistantMessageViewHolder(private val binding: ItemMessageAssistantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chatMessage: ChatMessage) {
            binding.userMessageTV.text = chatMessage.message
        }
    }

    class UserMessageViewHolder(private val binding: ItemMessageUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chatMessage: ChatMessage) {
            binding.userMessageTV.text = chatMessage.message
        }
    }

    class FeatureGroupViewHolder(private val binding: ItemFeatureChipsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(assistantMessage: ChatMessage) {
            binding.chipGroup
        }
    }
}