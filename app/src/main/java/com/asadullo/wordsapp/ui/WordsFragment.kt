package com.asadullo.wordsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.wordsapp.Adapter.AdapterWords
import com.asadullo.wordsapp.Models.User
import com.asadullo.wordsapp.Models.UserWords
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentWordsBinding
import com.asadullo.wordsapp.databinding.ItemWordsBinding
import com.asadullo.wordsapp.db.DbHelperWords
import com.google.android.material.bottomsheet.BottomSheetDialog

class WordsFragment : Fragment() {
    private val binding by lazy { FragmentWordsBinding.inflate(LayoutInflater.from(context)) }
    private lateinit var dbHelper: DbHelperWords
    private lateinit var adapter: AdapterWords
    private lateinit var list: ArrayList<UserWords>
    lateinit var user: User
    var wordsPosition = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.group.text = arguments?.getString("group")
        user = arguments?.getSerializable("keyGroup") as User
        binding.unit.text = user.name

        dbHelper = DbHelperWords.getIns(binding.root.context)
        list = dbHelper.dao().getAllWords() as ArrayList<UserWords>
        adapter = AdapterWords(list, object : AdapterWords.POSITION {
            override fun position(position: Int, eng: String, uzb: String, user: UserWords) {
                wordsPosition = "${position + 1} :WORDS"
                binding.position.text = wordsPosition
                binding.btnTest.setOnClickListener {
                    if (list.size<4){
                        Toast.makeText(
                            context,
                            "Test ishlash uchun kamida 4 ta so'z qo'shing",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                        findNavController().navigate(
                            R.id.testFragment,
                            bundleOf("position" to position, "keyList" to list)
                        )
                    }
                }
            }
        })
        binding.rv.adapter = adapter

        val itemTouchHelper = object : ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val swipe = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(0, swipe)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.onDismiss(viewHolder.adapterPosition)
                dbHelper.dao().delete(dbHelper.dao().getAllWords()[viewHolder.position])
            }


        }

        ItemTouchHelper(itemTouchHelper).attachToRecyclerView(binding.rv)

        binding.add.setOnClickListener {
            val item = ItemWordsBinding.inflate(LayoutInflater.from(binding.root.context))
            val dialog = BottomSheetDialog(binding.root.context)
            dialog.setContentView(item.root)

            item.btnAdd.setOnClickListener {
                val word = UserWords(item.edtEng.text.toString(), item.edtUzb.text.toString(), user.id)
                dbHelper.dao().addWord(word)
                binding.rv.adapter = adapter
                onResume()
                dialog.dismiss()
            }

            dialog.show()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        adapter.list.clear()

        list = ArrayList()
        val dList = dbHelper.dao().getAllWords() as ArrayList<UserWords>
        dList.forEach {
            if (it.groupId == user.id){
                list.add(it)
            }
        }

        adapter.list.addAll(list)
        adapter.notifyDataSetChanged()
    }
}