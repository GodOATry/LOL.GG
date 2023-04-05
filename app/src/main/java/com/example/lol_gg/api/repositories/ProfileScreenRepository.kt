package com.example.lol_gg.api.repositories

import com.example.lol_gg.api.BinarApi
import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.data.RegistrationJson
import com.example.lol_gg.data.ReturnDataFromRegistration
import com.example.lol_gg.data.ReturnDataFromSigningIn
import com.example.lol_gg.data.SigningInJson
import javax.inject.Inject

interface ProfileScreenRepository {
    suspend fun registerUser(
        summonerName: String,
        email: String,
        password: String
    ): NetworkResult<ReturnDataFromRegistration>
    suspend fun signInUser(email: String, password: String): NetworkResult<ReturnDataFromSigningIn>
}

class ProfileScreenRepositoryImplementation @Inject constructor(
    private val binarApi: BinarApi,
    private val dataStoreRepository: DataStoreRepository
) : ProfileScreenRepository {

    override suspend fun registerUser(
        summonerName: String,
        email: String,
        password: String
    ): NetworkResult<ReturnDataFromRegistration> {
        return try {
            val result = binarApi.registerUser(RegistrationJson(summonerName, email, password))
            NetworkResult.Success(result)
        } catch (e: Exception) {
            NetworkResult.Failure(e.message, e, 0)
        }
    }

    override suspend fun signInUser(
        email: String,
        password: String
    ): NetworkResult<ReturnDataFromSigningIn> {
        return try {
            val result = binarApi.signInUser(SigningInJson(email, password))
            dataStoreRepository.saveUserToDataStore(result)
            NetworkResult.Success(result)
        } catch (e: Exception) {
            NetworkResult.Failure(e.message, e, 0)
        }
    }
}
