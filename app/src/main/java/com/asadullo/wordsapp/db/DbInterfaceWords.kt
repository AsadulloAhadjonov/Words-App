package com.asadullo.wordsapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asadullo.wordsapp.Models.UserWords

@Dao
interface DbInterfaceWords {
    @Insert
    fun add(userWords: UserWords)

    @Query("select * from userwords")
    fun get():List<UserWords>
}