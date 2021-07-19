package com.example.composekit.data.source

import com.dropbox.android.external.store4.Store
import com.example.composekit.data.source.domain.PetModel

interface ComposeKitDataSource {
    fun getData(): Store<Int, List<PetModel>>
}
