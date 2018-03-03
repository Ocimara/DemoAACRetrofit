package com.example.ocimara.demoaacretrofit.api

import com.example.ocimara.demoaacretrofit.entities.Endereco
import retrofit2.Call
import retrofit2.http.GET

interface EnderecoAPI {

    @GET("/ws/{cep}/json/")
    fun pesquisar(cep: String): Call<Endereco>



}