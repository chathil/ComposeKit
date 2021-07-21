package com.example.composekit.core.data.source.remote.network

import com.example.composekit.core.data.source.remote.response.PetResponse
import retrofit2.http.GET

interface ApiService {
    @GET("pets.json")
    suspend fun getData(): List<PetResponse>
}
