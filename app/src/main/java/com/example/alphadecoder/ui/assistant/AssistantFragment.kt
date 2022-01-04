package com.example.alphadecoder.ui.assistant

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.alphadecoder.R
import com.example.alphadecoder.databinding.FragmentAssistantBinding
import com.example.alphadecoder.utils.Repository


class AssistantFragment : Fragment() {

    private var _binding: FragmentAssistantBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /* 0: invisible state
    * 1 : visible state
    * 2: typing state so change icon to send */
    private var assistance_button_state: Int = 0;

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
        /*    binding.micIV.setOnClickListener {
                binding.lottieMic.playAnimation()
            }*/
        binding.btnKeyboard.setOnClickListener {
            val editText = binding.messageEdit
            if (assistance_button_state != 2) {
                if (editText.visibility == View.VISIBLE) {
                    binding.btnKeyboard.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_keyboard
                        )
                    )
                    hideKeyboard()
                    editText.visibility = View.GONE
                    assistance_button_state = 0;
                } else {
                    binding.btnKeyboard.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_close
                        )
                    )
                    editText.visibility = View.VISIBLE
                    editText.requestFocus()
                    showKeyboard()
                    assistance_button_state = 1;
                }
            } else {
                //send text

            }
        }
        binding.messageEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 0) {
                    binding.btnKeyboard.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_close
                        )
                    )
                    assistance_button_state = 1
                } else {
                    binding.btnKeyboard.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_send
                        )
                    )
                    assistance_button_state = 2
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
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

    private fun hideKeyboard() {
        // Check if no view has focus:

        val inputManager: InputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            binding.messageEdit.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )

    }

    private fun showKeyboard() {
        // Check if no view has focus:
        val inputManager: InputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(binding.messageEdit, InputMethodManager.SHOW_IMPLICIT)
    }
}