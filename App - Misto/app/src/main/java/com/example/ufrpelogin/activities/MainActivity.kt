package com.example.ufrpelogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ufrpelogin.databinding.ActivityMainBinding
import com.example.ufrpelogin.db.DBHelper
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding =  ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            conferir2()
        }
        binding.CADASTAR.setOnClickListener {
            abrirTelaCadastro()
        }
        binding.Esqueci.setOnClickListener{
            telaESqueci()
        }
        binding.Bancodados.setOnClickListener{
            telaBancodados()
        }

    }


    private fun conferir() {

        val databaseHelper = DBHelper(this)
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(applicationContext, "Dados incompletos", Toast.LENGTH_SHORT).show()
        } else {
            if (databaseHelper.checkAluno(username, password)) {
                Toast.makeText(applicationContext, "Aluno Confirmado!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AlunoActivity::class.java))
            } else if (databaseHelper.checkProfessor(username, password)) {
                Toast.makeText(applicationContext, "Professor Confirmado!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfessorActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Usuário não encontrado, talvez você errou a senha.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun abrirTelaCadastro() {
        val intent = Intent(this, Cadastrar::class.java)
        startActivity(intent)
    }
    private fun telaESqueci(){
        val intent = Intent(this,EsqueceSenha_aluno::class.java )
        startActivity(intent)
    }
    private fun telaBancodados() {
        val intent = Intent(this,Cadastrar_bancodados::class.java)
        startActivity(intent)
    }
    private fun conferir2() {
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(applicationContext, "Dados incompletos", Toast.LENGTH_SHORT).show()
        } else {
            val auth = Firebase.auth
            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(applicationContext, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, AlunoActivity::class.java))
                    } else {
                        Toast.makeText(applicationContext, "Erro ao fazer login.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}


