package com.asadullo.wordsapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserWords {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var eng:String? = null
    var uzb:String? = null

    constructor(eng: String?, uzb: String?) {
        this.eng = eng
        this.uzb = uzb
    }

    constructor()


}