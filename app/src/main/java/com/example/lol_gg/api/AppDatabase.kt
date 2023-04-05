package com.example.lol_gg.api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lol_gg.data.room.User
import com.example.lol_gg.data.room.UserDAO

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun summonerNameDao(): UserDAO
}
