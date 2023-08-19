package com.example.ufrpelogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ufrpelogin.databinding.ActivityAlunoBancodadosBinding
import com.example.ufrpelogin.databinding.ActivityAlunoCadeiraBinding


class Cadastrar_bancodados : AppCompatActivity(){
    private lateinit var binding: ActivityAlunoBancodadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlunoBancodadosBinding.inflate(layoutInflater)
        setContentView(binding.root)



}

    }
