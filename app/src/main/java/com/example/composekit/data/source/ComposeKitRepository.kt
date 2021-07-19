package com.example.composekit.data.source

import android.util.Log
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.composekit.data.source.domain.PetModel
import com.example.composekit.data.source.local.entity.asDomainModels
import com.example.composekit.data.source.local.room.ComposeKitLocalDataSource
import com.example.composekit.data.source.remote.ComposeKitRemoteDataSource
import com.example.composekit.data.source.remote.response.asEntities
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@FlowPreview
@OptIn(ExperimentalCoroutinesApi::class)
class ComposeKitRepository @Inject constructor(
    private val local: ComposeKitLocalDataSource,
    private val remote: ComposeKitRemoteDataSource
) : ComposeKitDataSource {
    override fun getData(): Store<Int, List<PetModel>> =
        StoreBuilder.from(
            fetcher = Fetcher.of { remote.getData() },
            sourceOfTruth = SourceOfTruth.of(
                reader = { local.dao.loadPets().map { it.asDomainModels() } },
                writer = { _, input ->
                    Log.i(TAG, "getData: $input")
                    local.dao.insertPets(input.asEntities())
                },
                delete = local.dao::delete,
                deleteAll = local.dao::deleteAll
            )
        ).build()
    companion object {
        private val TAG = ComposeKitRepository::class.java.simpleName
    }
}
