package com.example.alphadecoder.ui.rewards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.alphadecoder.R
import com.example.alphadecoder.utils.Repository

class RewardsFragment : Fragment() {

    private lateinit var lottiView : LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rewards_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lottiView = view.findViewById(R.id.lottieConfettiView)
        view.findViewById<RecyclerView>(R.id.rewardsRV).apply {
            adapter =
                RewardsAdapter(Repository.getRewards()){appDetails ->
                    lottiView.playAnimation()
                }
            val helper = LinearSnapHelper()
            helper.attachToRecyclerView(this)
        }
    }


}