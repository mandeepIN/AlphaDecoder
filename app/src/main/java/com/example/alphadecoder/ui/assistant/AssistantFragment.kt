package com.example.alphadecoder.ui.assistant

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.alphadecoder.R
import com.example.alphadecoder.databinding.FragmentAssistantBinding
import com.example.alphadecoder.utils.Repository

class AssistantFragment : Fragment() {

    private var _binding: FragmentAssistantBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAssistantBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.micIV.setOnClickListener {
            binding.lottieMic.playAnimation()
        }
        binding.languageSelectorIV.setOnClickListener {
            binding.assistntRV.adapter =
                AssistantAdapter(Repository.getAssistantMessage(requireContext()), chipClick = {
                    when (it) {
                        requireContext().getString(R.string.change_language) -> {
                            activity?.let {
                                val intent = Intent(it, LanguageSelectionActivity::class.java)
                                it.startActivity(intent)
                            }
                        }
                    }
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                })

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}