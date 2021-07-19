package com.example.composekit.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composekit.data.source.local.entity.PetEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ComposeKitDatabaseModule {
    @Provides
    fun providesComposeKitDao(database: ComposeKitLocalDataSource): ComposeKitDao {
        return database.dao
    }
    @Provides
    @Singleton
    fun getComposeKitDatabase(@ApplicationContext context: Context): ComposeKitLocalDataSource {
        return Room.databaseBuilder(
            context.applicationContext,
            ComposeKitLocalDataSource::class.java,
            "compose_kit"
        ).build()
    }
}

@Database(
    entities = [PetEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ComposeKitLocalDataSource : RoomDatabase() {
    abstract val dao: ComposeKitDao
}
