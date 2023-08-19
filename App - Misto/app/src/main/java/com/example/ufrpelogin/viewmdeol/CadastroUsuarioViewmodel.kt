package com.example.ufrpelogin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ufrpelogin.FirebaseAuthRepository

class CadastroUsuarioViewModel(private val repository: FirebaseAuthRepository) : ViewModel() {

    fun cadastra(email: String, senha: String) {
        repository.cadastra(email, senha)
    }
}



