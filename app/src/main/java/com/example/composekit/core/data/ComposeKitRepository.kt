package com.example.composekit.core.data

import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.composekit.core.data.source.local.ComposeKitLocalDataSource
import com.example.composekit.core.data.source.local.entity.asDomainModels
import com.example.composekit.core.data.source.remote.ComposeKitRemoteDataSource
import com.example.composekit.core.data.source.remote.response.asEntities
import com.example.composekit.core.domain.model.PetModel
import com.example.composekit.core.domain.repository.IComposeKitRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@FlowPreview
@OptIn(ExperimentalCoroutinesApi::class)
class ComposeKitRepository @Inject constructor(
    private val local: ComposeKitLocalDataSource,
    private val remote: ComposeKitRemoteDataSource
) : IComposeKitRepository {
    override fun getData(): Store<Int, List<PetModel>> =
        StoreBuilder.from(
            fetcher = Fetcher.ofFlow { remote.getData() },
            sourceOfTruth = SourceOfTruth.of(
                reader = { local.loadPets().map { it.asDomainModels() } },
                writer = { _, input ->
                    local.insertPets(input.asEntities())
                },
                delete = local::delete,
                deleteAll = local::deleteAll
            )
        ).build()

    companion object {
        private val TAG = ComposeKitRepository::class.java.simpleName
    }
}
