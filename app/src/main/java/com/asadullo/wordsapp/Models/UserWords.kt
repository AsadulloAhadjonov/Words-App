package com.asadullo.wordsapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class UserWords : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var eng:String? = null
    var uzb:String? = null
    var groupId:Int? = null

    constructor(eng: String?, uzb: String?, groupId:Int?) {
        this.eng = eng
        this.uzb = uzb
        this.groupId = groupId
    }

    constructor()


}