package com.example.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.domain.model.PetModel

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String
)

fun PetEntity.asDomainModel() = PetModel(id, name, type)
fun List<PetEntity>.asDomainModels() = map { it.asDomainModel() }
