package com.asadullo.wordsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.asadullo.wordsapp.Adapter.AdapterRv
import com.asadullo.wordsapp.Models.User
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentHomeBinding
import com.asadullo.wordsapp.databinding.ItemDialogBinding
import com.asadullo.wordsapp.db.DbHelper
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var dbHelper: DbHelper
    private lateinit var adapter: AdapterRv
    private lateinit var list :ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dbHelper = DbHelper.getIns(binding.root.context)
        list = dbHelper.dao().get() as ArrayList<User>
        adapter = AdapterRv(list, object : AdapterRv.Clikc{
            override fun click(user: User, position: Int, unit: String) {
                findNavController().navigate(R.id.wordsFragment, bundleOf("group" to unit, "aa" to user.name))
            }
        })
        binding.rv.adapter = adapter

        binding.add.setOnClickListener {
            val item = ItemDialogBinding.inflate(LayoutInflater.from(binding.root.context))
            val dialog = BottomSheetDialog(binding.root.context)
            dialog.setContentView(item.root)

            item.btnAdd.setOnClickListener {
                val user = User(item.edtGroupName.text.toString())
                dbHelper.dao().add(user)
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
        adapter.list.addAll(dbHelper.dao().get())
        adapter.notifyDataSetChanged()
    }


}