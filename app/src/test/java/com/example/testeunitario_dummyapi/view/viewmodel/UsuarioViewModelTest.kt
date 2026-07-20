package com.example.testeunitario_dummyapi.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase
import com.example.testeunitario_dummyapi.util.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UsuarioViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var usuarioUseCase: UsuarioUseCase
    private lateinit var usuarioViewModel: UsuarioViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun recuperarListaUsuarios_validarLiveData_retornarLiveData() = runTest {

        Mockito.`when`(usuarioUseCase()).thenReturn(
            listOf(
                Usuario(35, "Harisson", "Silva"),
                Usuario(12, "Marina", "Monte"),
                Usuario(37, "Afonso", "Luiz"),
                Usuario(13, "Antônio", "Leite")
            )
        )

        usuarioViewModel = UsuarioViewModel(usuarioUseCase)
        usuarioViewModel.recuperUsuario()
        val usuarioLiveData = usuarioViewModel.listaUsuarios.getOrAwaitValue()

        assertThat(usuarioLiveData).isNotEmpty()

    }

    @After
    fun tearDown() {
        //
    }

}