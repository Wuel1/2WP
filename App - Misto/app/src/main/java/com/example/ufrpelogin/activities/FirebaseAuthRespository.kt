package com.example.ufrpelogin

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseAuthRepository(private val firebase: FirebaseAuth) {

    fun desloga() {
        firebase.signOut()
    }

    fun verificaUser(): FirebaseUser? {
        return firebase.currentUser
    }

    fun autenticaUser(email: String, senha: String) {
        firebase.signInWithEmailAndPassword(email, senha)
            .addOnSuccessListener {
                Log.i(tag, "Autenticação bem-sucedida")
            }.addOnFailureListener {
                Log.e(tag, "Falha na autenticação:", it)
            }
    }

    fun cadastra(email: String, senha: String) {
        firebase.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener {
                Log.i(tag, "Cadastro bem-sucedido")
            }.addOnFailureListener {
                Log.e(tag, "Falha no cadastro:", it)
            }
    }

    companion object {
        private val tag = "Firebase"
    }
}
