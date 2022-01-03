package com.example.alphadecoder.ui.familysecurity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
//        binding = ActivityFamilySecurityBinding.inflate(layoutInflater)
//        listPopupView.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, family))
//        listPopupView.setOnItemClickListener { _, _, position, _ ->
            /*selectionTextView.text = dataList[position]
            listPopupView.dismiss()
            // do other things on selection*/
//        }
//        listPopupView.anchorView = selectionTextView
        findViewById<RecyclerView>(R.id.appsListRV).adapter = AppSecurityAdapter(Repository.getApplications2())
//        binding.dropDown.setOnClickListener { listPopupView.show() }
//        binding.appsListRV.adapter = AppSecurityAdapter(Repository.getApplications2())
    }

    fun setApps() {
        binding.appsListRV.adapter
    }
}