package com.example.aplicationapi.repo

import android.database.Observable
import com.example.aplicationapi.data.remote.PromoService
import com.example.aplicationapi.data.remote.PromosApi
import com.example.aplicationapi.domain.items.PromosItem
import com.example.aplicationapi.domain.items.toPromosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class PromosRepository @Inject constructor(private val promoService: PromoService, private val promosApi: PromosApi) {

    suspend fun getPromo(): List<PromosItem>{
       return promoService.getPromo().map {
           it.toPromosItem()
       }

    }

  /*  suspend fun getPromo(callback: ApiCallback<List<PromosItem>>) {
        promosApi.getPromos().enqueue(object : Callback<List<PromosItem>> {
            override fun onResponse(call: Call<List<PromosItem>>, response: Response<List<PromosItem>>) {
                if (response.isSuccessful) {
                    callback.onResponse(response.body() ?: emptyList())
                } else {
                    callback.onFailure(Exception("Response is not successful"))
                }
            }

            override fun onFailure(call: Call<List<PromosItem>>, error: Throwable) {
                callback.onFailure(error)
            }
        })
    }*/

    suspend fun getPromoById(id : Int) : PromosItem {
        return  promoService.getPromoById(id).toPromosItem()
    }
}

private fun <T> Response<T>.enqueue(callback: Callback<List<PromosItem>>) {

}

