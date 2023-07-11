package com.example.widgetasaka.di

import com.example.widgetasaka.Repository
import com.example.widgetasaka.impl.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun bindsRepository(impl:RepositoryImpl):Repository
}