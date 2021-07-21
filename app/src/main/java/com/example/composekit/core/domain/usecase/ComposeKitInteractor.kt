package com.example.composekit.core.domain.usecase

import com.example.composekit.core.domain.repository.IComposeKitRepository
import javax.inject.Inject

class ComposeKitInteractor @Inject constructor(private val repository: IComposeKitRepository) : ComposeKitUseCase {
    override fun getData() = repository.getData()
}
