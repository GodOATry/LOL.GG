package com.example.lol_gg.api.repositories

import com.example.lol_gg.api.AppDatabase
import com.example.lol_gg.api.modules.IoDispatcher
import com.example.lol_gg.data.room.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface RoomRepository {
    suspend fun getAllSummonerNames(): List<User>
    suspend fun saveSummonerName(summonerNames: User)
    suspend fun deleteSummonerName(summonerNames: User)
}

class RoomRepositoryImplementation @Inject constructor(
    private val appDatabase: AppDatabase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RoomRepository {
    override suspend fun getAllSummonerNames(): List<User> {
        return withContext(ioDispatcher) {
            appDatabase.summonerNameDao().getAll()
        }
    }

    override suspend fun saveSummonerName(summonerNames: User) {
        withContext(ioDispatcher) {
            appDatabase.summonerNameDao().insertAll(summonerNames)
        }
    }

    override suspend fun deleteSummonerName(summonerNames: User) {
        withContext(ioDispatcher) {
            appDatabase.summonerNameDao().delete(summonerNames)
        }
    }
}
