package com.asadullo.wordsapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asadullo.wordsapp.Models.User

@Dao
interface DbInterface {
    @Insert
    fun add(user: User)

    @Query("select * from user")
    fun get():List<User>
}