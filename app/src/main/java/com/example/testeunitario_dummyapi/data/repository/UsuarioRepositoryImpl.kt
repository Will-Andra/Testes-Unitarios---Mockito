package com.example.testeunitario_dummyapi.data.remote.repository

import android.util.Log
import com.example.testeunitario_dummyapi.data.remote.api.DummyAPIService
import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.data.remote.dto.toUsuario
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository
import kotlinx.coroutines.delay

class UsuarioRepositoryImpl(
    private val dummyAPI: DummyAPIService
) : UsuarioRepository {

    override suspend fun recuperaUsuario(): List<Usuario> {
        return try {
            val respostaAPI = dummyAPI.recuperaUsuarios()

            if (respostaAPI.isSuccessful && respostaAPI.body() != null) {
                val listaUsuarios = respostaAPI.body()?.users
                listaUsuarios?.map { it.toUsuario() } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}