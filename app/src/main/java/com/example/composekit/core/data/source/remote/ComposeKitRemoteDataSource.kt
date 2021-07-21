package com.example.composekit.core.data.source.remote

import com.example.composekit.core.data.source.remote.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
@Singleton
class ComposeKitRemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getData() = flow { emit(apiService.getData()) }.flowOn(Dispatchers.IO)
}
