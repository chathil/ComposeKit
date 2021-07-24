package com.example.core.data.source.local

import com.example.core.data.source.local.entity.PetEntity
import com.example.core.data.source.local.room.ComposeKitDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComposeKitLocalDataSource @Inject constructor(private val composeKitDao: ComposeKitDao) {
    suspend fun insertPets(pets: List<PetEntity>) = composeKitDao.insertPets(pets)
    fun loadPets() = composeKitDao.loadPets()
    fun delete(id: Int) = composeKitDao.delete(id)
    fun deleteAll() = composeKitDao.deleteAll()
}
