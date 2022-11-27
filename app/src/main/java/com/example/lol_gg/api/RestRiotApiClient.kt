package com.example.lol_gg.api

import com.example.lol_gg.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestRiotApiClient {


    @Singleton
    @Provides
    fun provideRestRiotApiClient(okHttpClient: OkHttpClient): RiotApi = run {
        val retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(BuildConfig.RIOT_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        retrofit.create(RiotApi::class.java)
    }

}
