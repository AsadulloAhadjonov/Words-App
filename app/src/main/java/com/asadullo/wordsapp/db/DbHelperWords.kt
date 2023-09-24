package com.asadullo.wordsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asadullo.wordsapp.Models.UserWords

@Database(entities = [UserWords::class], version = 1)
abstract class DbHelperWords:RoomDatabase() {

    abstract fun dao():DbInterfaceWords

    companion object{
        private var instance:DbHelperWords? = null

        @Synchronized
        fun getIns(context: Context):DbHelperWords{

            if (instance == null){
                instance = Room.databaseBuilder(
                    context,
                    DbHelperWords::class.java,
                    "my_db_words"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}