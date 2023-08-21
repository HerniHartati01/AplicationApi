package com.example.aplicationapi.data.remote

import android.database.Observable
import com.example.aplicationapi.data.remote.models.PromosModel
import com.example.aplicationapi.util.Constants.Companion.PROMOS_ENDPOINT
import com.example.aplicationapi.util.Constants.Companion.PROMO_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PromosApi {

    @GET(PROMOS_ENDPOINT)
    suspend fun getPromos() : Response<List<PromosModel>>

    @GET(PROMO_ID_ENDPOINT)
    suspend fun getPromoById(@Query(value = "id") id : Int) : Response<PromosModel>
}