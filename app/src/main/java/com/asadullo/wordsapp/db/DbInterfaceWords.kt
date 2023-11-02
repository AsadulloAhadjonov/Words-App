package com.asadullo.wordsapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.asadullo.wordsapp.Models.User
import com.asadullo.wordsapp.Models.UserWords

@Dao
interface DbInterfaceWords {
    @Insert
    fun addWord(userWords: UserWords)

    @Query("select * from userwords")
    fun getAllWords():List<UserWords>

    @Insert
    fun addGroup(user: User)

    @Query("select * from user")
    fun getAllGroups():List<User>

    @Delete
    fun delete(userWords: UserWords)
}