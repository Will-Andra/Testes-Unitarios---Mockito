package com.example.testeunitario_dummyapi.data.repository

import com.example.testeunitario_dummyapi.data.dto.UserDTOTestHelper
import com.example.testeunitario_dummyapi.data.remote.api.DummyAPIService
import com.example.testeunitario_dummyapi.data.remote.dto.ResponseDummyApiUser
import com.example.testeunitario_dummyapi.data.remote.repository.UsuarioRepositoryImpl
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response


@RunWith(MockitoJUnitRunner::class)
class UsuarioRepositoryImplTest {

    @Mock
    private lateinit var dummyAPIService: DummyAPIService

    val userDTOHelper = UserDTOTestHelper()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun lista_recuperaListagemDeUsuariosAPI_retornaLista() = runTest {

        Mockito.`when`(dummyAPIService.recuperaUsuarios()).thenReturn(
            Response.success(
                ResponseDummyApiUser(
                    20, 10, 100,
                    listOf(
                        userDTOHelper.criarUserDTOFake("Jose", "Silva", 28),
                        userDTOHelper.criarUserDTOFake("Maria", "Santos", 32),
                        userDTOHelper.criarUserDTOFake("Pedro", "Pereira", 25),
                        userDTOHelper.criarUserDTOFake("Paulo", "Santos", 39),
                    )
                )
            )
        )

        val usuarioRepository = UsuarioRepositoryImpl(dummyAPIService)
        val lista = usuarioRepository.recuperaUsuario()

        assertThat(lista).isNotEmpty()

    }

    @After
    fun tearDown() {
        //
    }

}