package com.example.ufrpelogin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ufrpelogin.databinding.ActivityAlunoBancodadosBinding
import com.google.firebase.auth.FirebaseAuth

class Cadastrar_bancodados : AppCompatActivity() {
    private lateinit var binding: ActivityAlunoBancodadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlunoBancodadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrarBanco.setOnClickListener {
            cadastro_bancodedados() // Chamando o método para cadastrar no Firebase
        }
    }

    private fun cadastro_bancodedados() {
        val email = binding.emailBanco.text.toString()
        val senha = binding.SenhaBanco.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sucesso - usuário criado com sucesso no Firebase
                    val user = task.result?.user
                    // Você pode adicionar ações adicionais aqui, como navegar para outra tela
                } else {
                    // Tratamento de falha - exiba uma mensagem de erro ou faça o que for necessário
                    Log.e("FirebaseAuth", "Erro ao cadastrar usuário: ${task.exception}")
                }
            }
    }
}


