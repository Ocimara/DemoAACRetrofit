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
    private val mApiResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()


    val apiResponse: LiveData<EnderecoResponse>
        get() = mApiResponse

    init {

        enderecoRepository = EnderecoRepositoryImpl()

    }

    fun pesquisarEndereco(cep: String): LiveData<EnderecoResponse> {
        mApiResponse.addSource(
                enderecoRepository.buscarEndereco(cep)) {

            apiResponse ->
            mApiResponse.value = apiResponse
        }
        return mApiResponse
    }

}
