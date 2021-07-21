package com.example.composekit.core.di

import android.content.Context
import androidx.room.Room
import com.example.composekit.core.data.source.local.room.ComposeKitDao
import com.example.composekit.core.data.source.local.room.ComposeKitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun providesComposeKitDao(database: ComposeKitDatabase): ComposeKitDao {
        return database.dao
    }
    @Provides
    @Singleton
    fun provideComposeKitDatabase(@ApplicationContext context: Context): ComposeKitDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ComposeKitDatabase::class.java,
            "compose_kit"
        ).build()
    }
}
