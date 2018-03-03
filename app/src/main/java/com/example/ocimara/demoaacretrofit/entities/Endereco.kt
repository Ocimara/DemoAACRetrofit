package com.example.ocimara.demoaacretrofit.entities


data class Endereco (val cep: String,
                    val logradouro: String,
                    val complemeto: String,
                    val bairro: String,
                    val localidade: String,
                    val uf: String)