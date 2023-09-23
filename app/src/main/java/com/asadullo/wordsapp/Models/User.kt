package com.asadullo.wordsapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var name:String? = null

    constructor(name: String?) {
        this.name = name
    }

    constructor()


}