package com.example.lol_gg.api

import com.example.lol_gg.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RestBinarApiClient {

    @Provides
    fun provideBinarBaseUrl() = BuildConfig.BINAR_BASE_URL

    @Provides
    fun provideInterceptor() =  HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideBinarOkHttpClient(interceptor:HttpLoggingInterceptor) = run {
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideBinarRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    @Singleton
    @Provides
    fun provideRestBinarApiClient(retrofit: Retrofit) = retrofit.create(BinarApi::class.java)

}
