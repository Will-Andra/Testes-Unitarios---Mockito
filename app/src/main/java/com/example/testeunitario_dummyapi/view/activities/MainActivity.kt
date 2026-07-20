package com.example.testeunitario_dummyapi.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testeunitario_dummyapi.data.remote.network.RetrofitService
import com.example.testeunitario_dummyapi.data.remote.repository.UsuarioRepositoryImpl
import com.example.testeunitario_dummyapi.databinding.ActivityMainBinding
import com.example.testeunitario_dummyapi.domain.usecase.GetUsuarioUseCase
import com.example.testeunitario_dummyapi.view.viewmodel.UsuarioViewModel
import com.example.testeunitario_dummyapi.view.viewmodel.UsuarioViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializar()

    }

    private fun inicializar() {
        configurarViewModel()
        configurarObservavel()
    }

    private fun configurarObservavel() {
        usuarioViewModel.listaUsuarios.observe(this){listagem->
            var textoUsuario = ""
            listagem.forEach {
                textoUsuario += "+${it.primeiroNome} ${it.ultimoNome} (${it.idade}) \n\n"
            }
            binding.textConteudo.text = textoUsuario
        }
    }

    private fun configurarViewModel() {
        val serviceAPI = RetrofitService.dummyAPI
        val usuarioRepository = UsuarioRepositoryImpl(serviceAPI)
        val usuarioUseCase = GetUsuarioUseCase(usuarioRepository)
        usuarioViewModel = ViewModelProvider.create(this, UsuarioViewModelFactory(usuarioUseCase))[UsuarioViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        usuarioViewModel.recuperUsuario()
    }


}