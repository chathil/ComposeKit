package com.example.uimain

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dropbox.android.external.store4.ResponseOrigin
import com.dropbox.android.external.store4.StoreRequest
import com.dropbox.android.external.store4.StoreResponse
import com.example.core.data.ComposeKitRepository
import com.example.core.domain.model.PetModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ComposeKitRepository
) : ViewModel() {

    private val _pets = MutableStateFlow(emptyList<PetModel>())
    val pets: StateFlow<List<PetModel>>
        get() = _pets

    // Each view has it's own loading status
    private val _isLoading = MutableStateFlow(emptyList<HomeViewComponent>())
    val isLoading: StateFlow<List<HomeViewComponent>>
        get() = _isLoading

    private val _isError = MutableStateFlow<String?>(null)
    val isError: StateFlow<String?>
        get() = _isError

    init {
        viewModelScope.launch {
            repository.getData().stream(StoreRequest.cached(-1 /*no key*/, true))
                .collect { response ->
                    when (response) {
                        is StoreResponse.Loading -> _isLoading.value += HomeViewComponent.PET_LIST
                        is StoreResponse.Data -> {
                            if (response.origin == ResponseOrigin.Fetcher) _isLoading.value -= HomeViewComponent.PET_LIST
                            _pets.value = response.value
                            _isError.value = null
                        }
                        is StoreResponse.Error -> {
                            if (response.origin == ResponseOrigin.Fetcher) _isLoading.value -= HomeViewComponent.PET_LIST
                            _isError.value = "Error loading pets"
                            Log.e(TAG, "Pet error: ${response.errorMessageOrNull()}")
                        }
                        is StoreResponse.NoNewData -> {
                            if (response.origin == ResponseOrigin.Fetcher) _isLoading.value -= HomeViewComponent.PET_LIST
                            _isError.value = null
                        }
                    }
                }
        }
    }

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}
