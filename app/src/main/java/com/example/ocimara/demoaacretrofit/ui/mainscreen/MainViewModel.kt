package com.example.ocimara.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.*
import com.example.ocimara.demoaacretrofit.entities.EnderecoResponse
import com.example.ocimara.demoaacretrofit.repositories.EnderecoRepository
import com.example.ocimara.demoaacretrofit.repositories.EnderecoRepositoryImpl

class MainViewModel : ViewModel() {

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    private val enderecoRepository: EnderecoRepository
    private val mApiResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()


    val apiResponse: LiveData<EnderecoResponse>
        get() = mApiResponse

    init {

        enderecoRepository = EnderecoRepositoryImpl()

    }

    fun pesquisarEndereco(cep: String): LiveData<EnderecoResponse> {
        isLoading.postValue(true)

        mApiResponse.addSource(
                enderecoRepository.buscarEndereco(cep)) {

            apiResponse ->
            mApiResponse.value = apiResponse
            isLoading.postValue(false)
        }
        return mApiResponse
    }

}
