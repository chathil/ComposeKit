package com.example.composekit.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composekit.data.source.domain.PetModel

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String
)

fun PetEntity.asDomainModel() = PetModel(id, name, type)
fun List<PetEntity>.asDomainModels() = map { it.asDomainModel() }
