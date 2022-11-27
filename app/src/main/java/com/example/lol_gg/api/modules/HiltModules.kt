package com.example.lol_gg.api

import com.example.lol_gg.api.repositories.DataStoreRepository
import com.example.lol_gg.api.repositories.DataStoreRepositoryImplementation
import com.example.lol_gg.api.repositories.HomeScreenRepository
import com.example.lol_gg.api.repositories.HomeScreenRepositoryImplementation
import com.example.lol_gg.api.repositories.ProfileScreenRepository
import com.example.lol_gg.api.repositories.ProfileScreenRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class BinarApiModule {
    @Binds
    abstract fun HomeScreenRepositoryFunction(homeScreenRepository: HomeScreenRepositoryImplementation): HomeScreenRepository
    @Binds
    abstract fun dataStoreFunction(dataStoreRepository: DataStoreRepositoryImplementation): DataStoreRepository
    @Binds
    abstract fun ProfileScreenRepositoryFunction(profileScreenRepository: ProfileScreenRepositoryImplementation): ProfileScreenRepository
}



