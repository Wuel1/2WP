package com.example.ufrpelogin

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseAuthRespository (private val firabase: FirebaseAuth ) {
    private fun desloga(firabase: FirebaseAuth) {
        firabase.signOut()
    }

    private fun verifcaUser(firabase: FirebaseAuth) {
        val userfirebase: FirebaseUser? = firabase.currentUser
        if (userfirebase != null) {

        } else {

        }
    }

    private fun autenticauser(firabase: FirebaseAuth) {
        firabase.signInWithEmailAndPassword("pedro.henrique@ufrpe.com.br", "teste1234")
            .addOnSuccessListener {

            }.addOnFailureListener {
                Log.e(tag, "Oncreate:", it)

            }
    }

     fun cadastra(email: String, senha : String ) {
        val tarefa =
            firabase.createUserWithEmailAndPassword(email, senha)
        tarefa.addOnSuccessListener {
            Log.i(tag,"cadatrar:cadastro SUCESSO")
        }
        tarefa.addOnFailureListener {
            Log.e(tag, "FALHOU", it)

        }
    }




    private val tag = "MainActivity"
}