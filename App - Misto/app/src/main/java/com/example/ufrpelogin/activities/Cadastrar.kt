package com.example.ufrpelogin

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ufrpelogin.databinding.ActivityAlunoCadastrarBinding
import com.example.ufrpelogin.db.DBHelper

class Cadastrar : AppCompatActivity() {
    private lateinit var binding: ActivityAlunoCadastrarBinding
        private lateinit var dbHelper: DBHelper
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityAlunoCadastrarBinding.inflate(layoutInflater)
            setContentView(binding.root)
            dbHelper = DBHelper(this)

            binding.buttonCadastrar.setOnClickListener {
                cadastrarNovoAluno()
            }
        }

        private fun cadastrarNovoAluno() {
            val nome = binding.editTextName.text.toString()
            val matricula = binding.editTextMatricula.text.toString()
            val email = binding.editTextEmail.text.toString()
            val senha = binding.editTextSenha.text.toString()
            val mac = binding.editTextMAC.text.toString()

            if (nome.isNotEmpty() && matricula.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && mac.isNotEmpty()) {
                val resultado = dbHelper.alunosInsert(nome, senha, mac)
                if (resultado != -1L) {
                    Toast.makeText(this, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao cadastrar o aluno.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
