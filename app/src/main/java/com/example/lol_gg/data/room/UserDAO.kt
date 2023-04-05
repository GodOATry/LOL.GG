package com.example.lol_gg.data.room

import androidx.room.*

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(summonerName: User)

    @Delete
    fun delete(summonerName: User)
}
