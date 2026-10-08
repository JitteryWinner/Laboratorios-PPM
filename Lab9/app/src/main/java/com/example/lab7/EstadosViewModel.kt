package com.example.lab7

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class EstadoPantalla<T>(
    val isLoading: Boolean = true,
    val data: T? = null,
    val hasError: Boolean = false
)

class PersonajesViewModel : ViewModel() {
    private val db = CharacterDb()
    private val _estado = MutableStateFlow(EstadoPantalla<List<Character>>())
    val estado: StateFlow<EstadoPantalla<List<Character>>> = _estado
    private var trabajo: Job? = null

    init { cargar() }

    fun cargar() {
        trabajo?.cancel()
        _estado.value = EstadoPantalla()
        trabajo = viewModelScope.launch {
            delay(4000)
            try {
                _estado.value = EstadoPantalla(isLoading = false, data = db.getAllCharacters())
            } catch (e: Exception) {
                _estado.value = EstadoPantalla(isLoading = false, hasError = true)
            }
        }
    }

    fun mostrarError() {
        if (_estado.value.isLoading) {
            trabajo?.cancel()
            _estado.value = EstadoPantalla(isLoading = false, hasError = true)
        }
    }
}

class DetallePersonajeViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val id = savedStateHandle.toRoute<CharacterDetailsDestinos>().id
    private val db = CharacterDb()
    private val _estado = MutableStateFlow(EstadoPantalla<Character>())
    val estado: StateFlow<EstadoPantalla<Character>> = _estado
    private var trabajo: Job? = null

    init { cargar() }

    fun cargar() {
        trabajo?.cancel()
        _estado.value = EstadoPantalla()
        trabajo = viewModelScope.launch {
            delay(2000)
            try {
                _estado.value = EstadoPantalla(isLoading = false, data = db.getCharacterById(id))
            } catch (e: Exception) {
                _estado.value = EstadoPantalla(isLoading = false, hasError = true)
            }
        }
    }

    fun mostrarError() {
        if (_estado.value.isLoading) {
            trabajo?.cancel()
            _estado.value = EstadoPantalla(isLoading = false, hasError = true)
        }
    }
}

class UbicacionesViewModel : ViewModel() {
    private val db = LocationDb()
    private val _estado = MutableStateFlow(EstadoPantalla<List<Location>>())
    val estado: StateFlow<EstadoPantalla<List<Location>>> = _estado
    private var trabajo: Job? = null

    init { cargar() }

    fun cargar() {
        trabajo?.cancel()
        _estado.value = EstadoPantalla()
        trabajo = viewModelScope.launch {
            delay(4000)
            try {
                _estado.value = EstadoPantalla(isLoading = false, data = db.getAllLocations())
            } catch (e: Exception) {
                _estado.value = EstadoPantalla(isLoading = false, hasError = true)
            }
        }
    }

    fun mostrarError() {
        if (_estado.value.isLoading) {
            trabajo?.cancel()
            _estado.value = EstadoPantalla(isLoading = false, hasError = true)
        }
    }
}

class DetalleUbicacionViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val id = savedStateHandle.toRoute<LocationDetailsDestinos>().id
    private val db = LocationDb()
    private val _estado = MutableStateFlow(EstadoPantalla<Location>())
    val estado: StateFlow<EstadoPantalla<Location>> = _estado
    private var trabajo: Job? = null

    init { cargar() }

    fun cargar() {
        trabajo?.cancel()
        _estado.value = EstadoPantalla()
        trabajo = viewModelScope.launch {
            delay(2000)
            try {
                _estado.value = EstadoPantalla(isLoading = false, data = db.getLocationById(id))
            } catch (e: Exception) {
                _estado.value = EstadoPantalla(isLoading = false, hasError = true)
            }
        }
    }

    fun mostrarError() {
        if (_estado.value.isLoading) {
            trabajo?.cancel()
            _estado.value = EstadoPantalla(isLoading = false, hasError = true)
        }
    }
}
