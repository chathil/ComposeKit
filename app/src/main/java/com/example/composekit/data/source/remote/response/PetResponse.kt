package com.example.composekit.data.source.remote.response

import com.example.composekit.data.source.local.entity.PetEntity
import kotlinx.serialization.Serializable

@Serializable
data class PetResponse(
    val id: Int,
    val name: String,
    val type: String
)

fun PetResponse.asEntity() = PetEntity(id, name, type)
fun List<PetResponse>.asEntities() = map { it.asEntity() }
