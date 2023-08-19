package com.example.ufrpelogin.viewmdeol

import androidx.lifecycle.ViewModel
import com.example.ufrpelogin.FirebaseAuthRespository

class CadastroUsuarioViewmodel(private val respository: FirebaseAuthRespository) : ViewModel() {
    fun cadastra(email : String, senha : String ){
        respository.cadastra(email,senha )
    }


}