package com.asadullo.wordsapp.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentTestBinding
import com.asadullo.wordsapp.db.DbHelperWords

class TestFragment : Fragment() {
    private val binding by lazy { FragmentTestBinding.inflate(layoutInflater) }
    var javob1 = true
    var javob2 = true
    var javob3 = true
    var javob4 = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.javob1.setOnClickListener {
            if (javob1){
                binding.javob1.setBackgroundResource(R.drawable.bac_j_1)
                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
            }
        }

        binding.javob2.setOnClickListener {
            if (javob2){
                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob2.setBackgroundResource(R.drawable.bac_j_1)
                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
            }
        }

        binding.javob3.setOnClickListener {
            if (javob3){
                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob3.setBackgroundResource(R.drawable.bac_j_1)
                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
            }
        }

        binding.javob4.setOnClickListener {
            if (javob4){
                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                binding.javob4.setBackgroundResource(R.drawable.bac_j_1)
            }
        }

        return binding.root
    }


}