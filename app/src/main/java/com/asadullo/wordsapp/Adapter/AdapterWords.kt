package com.asadullo.wordsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.wordsapp.Models.UserWords
import com.asadullo.wordsapp.databinding.ItemAdapterBinding
import com.asadullo.wordsapp.databinding.ItemRvBinding
import com.asadullo.wordsapp.listner.ButtonClickListner
import java.util.Collections

class AdapterWords(var list: ArrayList<UserWords>, val position1:POSITION) : RecyclerView.Adapter<AdapterWords.Vh>(), ButtonClickListner{
    inner class Vh(var item: ItemAdapterBinding) : RecyclerView.ViewHolder(item.root) {
        fun onBind(user: UserWords, position: Int) {
            item.txtIng.text = user.eng
            item.txtUzb.text = user.uzb
            position1.position(position, list[position].eng.toString(), list[position].uzb.toString(), user)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface POSITION{
        fun position(position: Int, eng:String, uzb:String, user: UserWords)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition > toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(list, i, i+1)
            }
        }else{
            for (i in fromPosition until toPosition+1){
                Collections.swap(list, i, i-1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onDismiss(pos: Int) {
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

}