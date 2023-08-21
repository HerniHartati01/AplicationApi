package com.example.aplicationapi.data.remote

import com.example.aplicationapi.data.remote.models.PromosModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PromoService @Inject constructor(private val promosApi: PromosApi) {

    suspend fun getPromo(): List<PromosModel>{

        return withContext(Dispatchers.IO){
            val promos = promosApi.getPromos()
            promos.body()?: emptyList()
        }
    }

    suspend fun getPromoById(id : Int) : PromosModel{
        return withContext(Dispatchers.IO){
            val promo = promosApi.getPromoById(id)
            promo.body()!!
        }
    }

}