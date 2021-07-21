package com.example.composekit.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composekit.core.data.source.local.entity.PetEntity

@Database(
    entities = [PetEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ComposeKitDatabase : RoomDatabase() {
    abstract val dao: ComposeKitDao
}
