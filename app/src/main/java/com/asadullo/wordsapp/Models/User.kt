package com.asadullo.wordsapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User :Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var name:String? = null

    constructor(name: String?) {
        this.name = name
    }

    constructor()


}