package com.example.composekit.data.source.domain

import com.example.composekit.data.source.local.entity.PetEntity

data class PetModel(
    val id: Int,
    val name: String,
    val type: String
)

fun PetModel.asEntity() = PetEntity(id, name, type)
fun List<PetModel>.asEntities() = map { it.asEntity() }
