package com.asadullo.wordsapp.listner

import java.text.FieldPosition
import java.text.ParsePosition

interface ButtonClickListner {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onDismiss(pos:Int)
}