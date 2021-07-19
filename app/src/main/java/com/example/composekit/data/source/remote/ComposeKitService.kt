package com.example.composekit.data.source.remote

import com.example.composekit.data.source.remote.response.PetResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private val contentType = MediaType.parse("application/json")
const val API_KEY = "" // key from BuildConfig/ gradle.properties
private const val BASE_URL =
    "https://raw.githubusercontent.com/chathil/adoptme-android/master/app/src/main/assets/"

private val json = Json { ignoreUnknownKeys = true }

@ExperimentalSerializationApi
private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(json.asConverterFactory(MediaType.get("application/json"))).build()

interface ComposeKitService {
    @GET("pets.json")
    suspend fun getData(): List<PetResponse>
}

object ComposeKitApi {
    @ExperimentalSerializationApi
    val composeKitService: ComposeKitService by lazy {
        retrofit.create(
            ComposeKitService::class.java
        )
    }
}
