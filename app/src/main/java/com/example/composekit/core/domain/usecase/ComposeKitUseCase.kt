package com.example.composekit.core.domain.usecase

import com.dropbox.android.external.store4.Store
import com.example.composekit.core.domain.model.PetModel

interface ComposeKitUseCase {
    fun getData(): Store<Int, List<PetModel>>
}
