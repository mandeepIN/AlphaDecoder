package com.example.alphadecoder.ui.familysecurity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListPopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.alphadecoder.R
import com.example.alphadecoder.databinding.ActivityFamilySecurityBinding
import com.example.alphadecoder.utils.Repository


class FamilySecurityActivity : AppCompatActivity() {
    val family = listOf<String>("Mom", "Dad", "Brother")
    private lateinit var binding: ActivityFamilySecurityBinding
    private lateinit var mAdapter: ArrayAdapter<String>
    private val listPopupView by lazy { ListPopupWindow(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_security)
        findViewById<RecyclerView>(R.id.appsListRV).adapter =
            AppSecurityAdapter(Repository.getApplications2())
        setupDropDown()
    }

    private fun setupDropDown() {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            com.example.alphadecoder.R.layout.item_dropdown,
            family
        )

        val editTextFilledExposedDropdown =
            findViewById<AutoCompleteTextView>(R.id.filled_exposed_dropdown)
        editTextFilledExposedDropdown.setAdapter(adapter)

    }

}