package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository

class GetUsuarioUseCase(
    private val usuarioRepository: UsuarioRepository
) : UsuarioUseCase {

    override suspend fun invoke(): List<Usuario> {
        val listaUsuario = usuarioRepository.recuperaUsuario()
        return listaUsuario.filter {
            it.idade >= 20
        }
    }
}