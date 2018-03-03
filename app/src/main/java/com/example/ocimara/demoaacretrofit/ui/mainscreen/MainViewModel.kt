package com.example.ocimara.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.example.ocimara.demoaacretrofit.entities.EnderecoResponse
import com.example.ocimara.demoaacretrofit.repositories.EnderecoRepository
import com.example.ocimara.demoaacretrofit.repositories.EnderecoRepositoryImpl

class MainViewModel : ViewModel() {
    private val enderecoRepository: EnderecoRepository
    private val apiResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()

    init {

        enderecoRepository = EnderecoRepositoryImpl()

    }

    fun pesquisarEndereco(cep: String): LiveData<EnderecoResponse> {


    }

}
