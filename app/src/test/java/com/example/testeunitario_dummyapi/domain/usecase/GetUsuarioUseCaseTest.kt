package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.data.repository.UsuarioRepositoryImplTest
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsuarioUseCaseTest {

    @Mock
    private lateinit var usuarioRepository: UsuarioRepository

    private lateinit var usuarioUseCase: UsuarioUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun invoke_listadeUsuarios_retornaListaFiltrada() = runTest {

        Mockito.`when`(usuarioRepository.recuperaUsuario()).thenReturn(
            listOf(
                Usuario(35, "Harisson", "Silva"),
                Usuario(12, "Marina", "Monte"),
                Usuario(37, "Afonso", "Luiz"),
                Usuario(13, "Antônio", "Leite")
            )
        )

        val usuarioUseCase = GetUsuarioUseCase(usuarioRepository)
        val resultadoListaFiltro = usuarioUseCase()

        assertThat(resultadoListaFiltro).isNotEmpty()
        assertThat(resultadoListaFiltro).hasSize(2)
        assertThat(resultadoListaFiltro.map { it.primeiroNome }).containsExactly("Harisson","Afonso")
    }

    @After
    fun tearDown() {
        //
    }

}