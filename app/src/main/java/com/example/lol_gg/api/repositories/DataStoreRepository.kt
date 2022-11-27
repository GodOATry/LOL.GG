package com.example.lol_gg.api.repositories

import androidx.datastore.core.DataStore
import com.example.lol_gg.UserData
import com.example.lol_gg.api.modules.IoDispatcher
import com.example.lol_gg.data.ReturnDataFromSigningIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DataStoreRepository {
    suspend fun saveUserToDataStore(user: ReturnDataFromSigningIn)
    suspend fun getUserFromDataStore(): Flow<ReturnDataFromSigningIn?>
}

class DataStoreRepositoryImplementation @Inject constructor(
    private val userProtoDataStore: DataStore<UserData>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : DataStoreRepository {

    override suspend fun saveUserToDataStore(user: ReturnDataFromSigningIn) {
        withContext(ioDispatcher) {
            userProtoDataStore.updateData { currentUserData ->
                currentUserData.toBuilder()
                    .setKind(user.kind)
                    .setLocalId(user.localId)
                    .setEmail(user.email)
                    .setDisplayName(user.displayName)
                    .setIdToken(user.idToken)
                    .setRegistered(user.registered)
                    .setRefreshToken(user.refreshToken)
                    .setExpiresIn(user.expiresIn)
                    .build()
            }
        }
    }

    override suspend fun getUserFromDataStore(): Flow<ReturnDataFromSigningIn?> =
        userProtoDataStore.data.map { user ->
            ReturnDataFromSigningIn(
                kind = user.kind,
                localId = user.localId,
                email = user.email,
                displayName = user.displayName,
                idToken = user.idToken,
                registered = user.registered,
                refreshToken = user.refreshToken,
                expiresIn = user.expiresIn
            )
        }.flowOn(ioDispatcher)
}
