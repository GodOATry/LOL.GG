package com.example.lol_gg.api.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.lol_gg.UserData
import com.example.lol_gg.data.datastore.UserSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreServiceModule {

    private val Context.userProtoDataStore: DataStore<UserData> by dataStore(
        fileName = "user.pb",
        serializer = UserSerializer
    )


    @Singleton
    @Provides
    fun provideUserProtoDataStore(@ApplicationContext appContext: Context): DataStore<UserData> = appContext.userProtoDataStore
}