package com.example.ocimara.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ocimara.demoaacretrofit.R
import com.example.ocimara.demoaacretrofit.api.EnderecoAPI
import com.example.ocimara.demoaacretrofit.entities.EnderecoResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btPesquisar.setOnClickListener {
            mainViewModel.pesquisarEndereco(etCEP.text.toString())
        }

        mainViewModel.apiResponse.observe(this, Observer { apiResponse ->
            if (apiResponse?.erro == null) {
                Log.i("TAG", "SUCESSO")

                val end = apiResponse?.endereco

                tvResultado.text =
                                    "CEP: ${end?.cep}\n" +
                                    "Logradouro: ${end?.logradouro}\n" +
                                    "Complemento: ${end?.complemeto}\n" +
                                    "Bairro: ${end?.bairro}\n" +
                                    "Localidade: ${end?.localidade}\n" +
                                    "UF: ${end?.uf}"


            } else {
                Log.i("TAG", "ERRO: ${apiResponse.erro}")
                tvResultado.text = "Sistema Indisponível \n Tente mais tarde!"

            }
        })

        mainViewModel.isLoading.observe(this,Observer{
            isLoading ->

            if (isLoading!!){
                loading.visibility = View.VISIBLE

            }
            else
            {
                loading.visibility = View.GONE
            }

                 })
    }

}
