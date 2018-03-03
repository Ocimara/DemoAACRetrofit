package com.example.ocimara.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.ocimara.demoaacretrofit.entities.EnderecoResponse

/**
 * Created by logonrm on 03/03/2018.
 */
interface EnderecoRepository{

    fun buscarEndereco(cep: String): LiveData<EnderecoResponse>



}