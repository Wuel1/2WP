package com.example.ufrpelogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ufrpelogin.databinding.ActivityAlunoBancodadosBinding
import com.example.ufrpelogin.viewmodel.CadastroUsuarioViewModel
import com.google.firebase.auth.FirebaseAuth

class Cadastrar_bancodados : AppCompatActivity() {

    private lateinit var binding: ActivityAlunoBancodadosBinding
    private lateinit var viewModel: CadastroUsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlunoBancodadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseAuthRepository = FirebaseAuthRepository(firebaseAuth)
        viewModel = CadastroUsuarioViewModel(firebaseAuthRepository)

        binding.buttonCadastrarBanco.setOnClickListener {

            val email = binding.emailBanco.text.toString()
            val senha = binding.SenhaBanco.text.toString()
            viewModel.cadastra(email, senha)

        }
    }
}
