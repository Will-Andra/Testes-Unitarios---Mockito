package com.example.testeunitario_dummyapi.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase

class UsuarioViewModelFactory(
    private val usuarioUseCase: UsuarioUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsuarioViewModel(usuarioUseCase) as T
    }

}