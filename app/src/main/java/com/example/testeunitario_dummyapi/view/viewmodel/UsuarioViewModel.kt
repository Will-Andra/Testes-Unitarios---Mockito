package com.example.testeunitario_dummyapi.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val usuarioUseCase: UsuarioUseCase
) : ViewModel() {

    private val _listaUsuarios = MutableLiveData<List<Usuario>>()

    val listaUsuarios: LiveData<List<Usuario>>
        get() = _listaUsuarios

    fun recuperUsuario() {

        try {
            viewModelScope.launch ( Dispatchers.IO ){
                val listagem = usuarioUseCase()
                _listaUsuarios.postValue(listagem)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _listaUsuarios.postValue(emptyList())
        }
    }
}