package com.example.lab7

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.sesionDataStore by preferencesDataStore(name = "sesion_usuario")

class SesionDatos(private val context: Context) {
    private val claveNombre = stringPreferencesKey("name")

    val nombre: Flow<String?> = context.sesionDataStore.data.map { preferencias ->
        preferencias[claveNombre]
    }

    suspend fun iniciarSesion(nombre: String) {
        context.sesionDataStore.edit { preferencias ->
            preferencias[claveNombre] = nombre.trim()
        }
    }

    suspend fun cerrarSesion() {
        context.sesionDataStore.edit { preferencias ->
            preferencias.remove(claveNombre)
        }
    }
}