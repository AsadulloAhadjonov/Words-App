package com.asadullo.wordsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.wordsapp.Models.UserWords
import com.asadullo.wordsapp.databinding.ItemAdapterBinding
import com.asadullo.wordsapp.databinding.ItemRvBinding

class AdapterWords(var list: ArrayList<UserWords>) : RecyclerView.Adapter<AdapterWords.Vh>() {
    inner class Vh(var item: ItemAdapterBinding) : RecyclerView.ViewHolder(item.root) {
        fun onBind(user: UserWords) {
            item.txtIng.text = user.eng
            item.txtUzb.text = user.uzb

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

}