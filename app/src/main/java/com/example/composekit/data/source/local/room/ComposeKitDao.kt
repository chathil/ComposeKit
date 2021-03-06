package com.example.composekit.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composekit.data.source.local.entity.PetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComposeKitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPets(pets: List<PetEntity>)

    @Query("SELECT * FROM pet")
    fun loadPets(): Flow<List<PetEntity>>

    @Query("DELETE FROM pet WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM pet")
    suspend fun deleteAll()
}
