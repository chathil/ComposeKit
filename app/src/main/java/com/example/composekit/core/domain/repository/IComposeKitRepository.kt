package com.example.composekit.core.domain.repository

import com.dropbox.android.external.store4.Store
import com.example.composekit.core.domain.model.PetModel

interface IComposeKitRepository {
    fun getData(): Store<Int, List<PetModel>>
}