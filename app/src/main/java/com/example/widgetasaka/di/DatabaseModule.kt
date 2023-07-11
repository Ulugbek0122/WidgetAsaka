package com.example.widgetasaka.di

import android.content.Context
import androidx.room.Room
import com.example.widgetasaka.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideLocalDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "db_local")
            .build()

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase) = appDatabase.currencyDao()
}