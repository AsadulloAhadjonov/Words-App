package com.asadullo.wordsapp.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asadullo.wordsapp.Models.User

@Database(entities = [User::class], version = 1)
abstract class DbHelper:RoomDatabase() {

    abstract fun dao():DbInterface

    companion object{
        private var instance:DbHelper? = null

        @Synchronized
        fun getIns(context: Context):DbHelper{

            if (instance == null){
                instance = Room.databaseBuilder(
                    context,
                    DbHelper::class.java,
                    "my_db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}