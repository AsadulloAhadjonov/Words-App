package com.asadullo.wordsapp.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.wordsapp.Models.User
import com.asadullo.wordsapp.databinding.ItemRvBinding

class AdapterRv(var list: ArrayList<User> = ArrayList(), val click:Clikc) : RecyclerView.Adapter<AdapterRv.Vh>() {
    inner class Vh(var item: ItemRvBinding) : RecyclerView.ViewHolder(item.root) {
        @SuppressLint("Range")
        fun onBind(user: User, position: Int) {
            val unit = "GROUP ${position+1}"
            item.txtItem.text = user.name
            item.txtItemCount.text = unit
            item.root.setOnClickListener {
                click.click(user, position, unit)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface Clikc{
        fun click(user: User, position: Int, unit:String)
    }
}