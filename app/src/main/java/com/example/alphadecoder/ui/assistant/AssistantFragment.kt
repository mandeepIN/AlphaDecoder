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
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.AssistantAction
import com.example.alphadecoder.Collection
import com.example.alphadecoder.R
import com.example.alphadecoder.databinding.FragmentAssistantBinding
import com.example.alphadecoder.utils.Repository


class AssistantFragment : Fragment() {

    private var _binding: FragmentAssistantBinding? = null
    private lateinit var adapter: AssistantAdapter

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
        return binding.root
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
                adapter.addData(AssistantAction(type = 0, binding.messageEdit.text.toString()))
                when {
                    binding.messageEdit.text.contains("Racing", true) -> {
                        adapter.addData(
                            Repository.getRacingGames()
                        )
                    }
                    binding.messageEdit.text.contains("Amazon", true) -> adapter.addData(
                        AssistantAction(
                            type = 3,
                            message = "",
                            appDetails = AppDetails(
                                "Amazon",
                                "https://im.indiatimes.in/content/2021/Sep/241448122_226907436060727_3612715713474855933_n_613c58ca5e864.jpg?w=725&h=906"
                            ),
                            collection = Collection(
                                "",
                                Repository.getApplications3() + Repository.getApplications2() + Repository.getApplications()
                            )
                        )
                    )
                    binding.messageEdit.text.contains(
                        "myntra",
                        true
                    ) -> adapter.addData(Repository.getMyntraRecommendation())
                    binding.messageEdit.text.contains(
                        "space",
                        true
                    ) -> adapter.addData(Repository.getCleanSpaceMessage())
                    binding.messageEdit.text.contains(
                        "jacket",
                        true
                    ) -> adapter.addData(Repository.getFashionApps())
                    else -> adapter.addData(Repository.getNoFoundMessage())
                }
                binding.messageEdit.text.clear()
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
        adapter = AssistantAdapter(
                Repository.getAssistantMessage(requireContext()) as ArrayList<AssistantAction>,
                chipClick = {
                    when (it) {
                        requireContext().getString(R.string.change_language) -> {
                            activity?.let {
                                val intent = Intent(it, LanguageSelectionActivity::class.java)
                                it.startActivity(intent)
                            }
                        }
                        requireContext().getString(R.string.app_search) -> {
                            adapter.addData(Repository.getAssistantMessage2(requireContext()))
                        }
                        requireContext().getString(R.string.search_for_apps) -> {
                            adapter.addData(Repository.getFashionApps())
                        }

                    }
                })
        binding.assistntRV.adapter = adapter

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