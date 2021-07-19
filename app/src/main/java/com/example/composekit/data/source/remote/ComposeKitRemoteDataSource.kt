package com.example.composekit.data.source.remote

import javax.inject.Inject

@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
class ComposeKitRemoteDataSource @Inject constructor() {
    suspend fun getData() = ComposeKitApi.composeKitService.getData()
}
