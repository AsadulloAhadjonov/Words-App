package com.asadullo.wordsapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.asadullo.wordsapp.Models.UserWords
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentTestBinding
import com.asadullo.wordsapp.db.DbHelperWords
import java.util.Random

class TestFragment : Fragment() {
    private val binding by lazy { FragmentTestBinding.inflate(layoutInflater) }
    private lateinit var dblist: ArrayList<UserWords>
    private lateinit var dbHelperWords: DbHelperWords
    private lateinit var list: ArrayList<Int>
    private var count = 0
    var count_true = 0
    var count_false = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = ArrayList()
        dbHelperWords = DbHelperWords.getIns(binding.root.context)
        dblist = dbHelperWords.dao().getAllWords() as ArrayList<UserWords>
        trueAnswer()
        binding.btnNext.setOnClickListener {
            binding.javob1.isEnabled = true
            binding.javob2.isEnabled = true
            binding.javob3.isEnabled = true
            binding.javob4.isEnabled = true
            binding.javob1.setBackgroundResource(R.drawable.bac_1)
            binding.javob2.setBackgroundResource(R.drawable.bac_1)
            binding.javob3.setBackgroundResource(R.drawable.bac_1)
            binding.javob4.setBackgroundResource(R.drawable.bac_1)
//            count_false++
            count++
            trueAnswer()
        }


        return binding.root
    }



    @SuppressLint("ResourceType")
    private fun trueAnswer() {
        if (count == dblist.size){
            val dialog = AlertDialog.Builder(binding.root.context)
                .setTitle("Natija")
                .setMessage("To'g'ri javoblar soni: $count_true \n Xato javoblar soni: $count_false")
                .setPositiveButton("Ok") { _, _ ->
                    findNavController().navigate(R.id.homeFragment)
                }.setNegativeButton("Cancel") { _, _ ->
                    findNavController().navigate(R.id.testFragment)
                }
                .create()

            dialog.show()
        }else {
            var question: UserWords
            var answer1: UserWords
            var answer2: UserWords
            var answer3: UserWords
            var answer4: UserWords

//                count = Random().nextInt(dblist.size)
                question = dblist[count]
                val num2 = Random().nextInt(dblist.size)
                val num3 = Random().nextInt(dblist.size)
                val num4 = Random().nextInt(dblist.size)

                if (count != num2 && count != num3 && num2 != num3 && count != num4 && num2 != num4 && num3 != num4) {
                    answer1 = dblist[num2]
                    answer2 = dblist[num3]
                    answer3 = dblist[num4]
                    answer4 = dblist[count]

                    val answers = listOf(answer1, answer2, answer3, answer4).shuffled()

                    binding.textWord.text = question.eng
                    binding.radio1.text = answers[0].uzb
                    binding.radio2.text = answers[1].uzb
                    binding.radio3.text = answers[2].uzb
                    binding.radio4.text = answers[3].uzb

                    binding.javob1.setOnClickListener {
                        binding.javob1.isEnabled = false
                        binding.javob2.isEnabled = false
                        binding.javob3.isEnabled = false
                        binding.javob4.isEnabled = false
                        if (binding.radio1.text == question.uzb) {
                            binding.javob1.setBackgroundResource(R.drawable.bac_j_1)
                            binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            Toast.makeText(binding.root.context, "To'g'ri", Toast.LENGTH_SHORT).show()
                            count_true++
                        } else {
                            Toast.makeText(binding.root.context, "Xato", Toast.LENGTH_SHORT).show()
                            count_false++
                            if (binding.radio2.text == question.uzb){
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio3.text == question.uzb){
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio4.text == question.uzb){
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            }
                        }
//                        trueAnswer()
//                        count++
                    }

                    binding.javob2.setOnClickListener {
                        binding.javob1.isEnabled = false
                        binding.javob2.isEnabled = false
                        binding.javob3.isEnabled = false
                        binding.javob4.isEnabled = false
                        if (binding.radio2.text == question.uzb) {
                            binding.javob2.setBackgroundResource(R.drawable.bac_j_1)
                            binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            Toast.makeText(binding.root.context, "To'g'ri", Toast.LENGTH_SHORT).show()
                            count_true++
                        } else {
                            Toast.makeText(binding.root.context, "Xato", Toast.LENGTH_SHORT).show()
                            count_false++
                            if (binding.radio1.text == question.uzb){
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio3.text == question.uzb){
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio4.text == question.uzb){
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            }
                        }
//                        trueAnswer()
//                        count++
                    }

                    binding.javob3.setOnClickListener {
                        binding.javob1.isEnabled = false
                        binding.javob2.isEnabled = false
                        binding.javob3.isEnabled = false
                        binding.javob4.isEnabled = false
                        if (binding.radio3.text == question.uzb) {
                            binding.javob3.setBackgroundResource(R.drawable.bac_j_1)
                            binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            Toast.makeText(binding.root.context, "To'g'ri", Toast.LENGTH_SHORT).show()
                            count_true++
                        } else {
                            Toast.makeText(binding.root.context, "Xato", Toast.LENGTH_SHORT).show()
                            count_false++
                            if (binding.radio1.text == question.uzb){
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio2.text == question.uzb){
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio4.text == question.uzb){
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            }
                        }
//                        trueAnswer()
//                        count++
                    }

                    binding.javob4.setOnClickListener {
                        binding.javob1.isEnabled = false
                        binding.javob2.isEnabled = false
                        binding.javob3.isEnabled = false
                        binding.javob4.isEnabled = false
                        if (binding.radio4.text == question.uzb) {
                            binding.javob4.setBackgroundResource(R.drawable.bac_j_1)
                            binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                            Toast.makeText(binding.root.context, "To'g'ri", Toast.LENGTH_SHORT).show()
                            count_true++
                        } else {
                            Toast.makeText(binding.root.context, "Xato", Toast.LENGTH_SHORT).show()
                            count_false++
                            if (binding.radio2.text == question.uzb){
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio3.text == question.uzb){
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                            }else if (binding.radio1.text == question.uzb){
                                binding.javob1.setBackgroundResource(R.drawable.bac_j_1)
                                binding.javob2.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob4.setBackgroundResource(R.drawable.bac_j_2)
                                binding.javob3.setBackgroundResource(R.drawable.bac_j_2)
                            }
                        }
//                        trueAnswer()
//                        count++
                    }

                    return
                }else{
                    trueAnswer()
                }

        }

    }
}
