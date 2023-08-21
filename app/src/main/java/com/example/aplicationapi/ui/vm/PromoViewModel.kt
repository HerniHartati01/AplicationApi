package com.example.aplicationapi.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationapi.domain.GetPromoByIdUseCase
import com.example.aplicationapi.domain.GetPromoUseCase
import com.example.aplicationapi.domain.items.PromosItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(
    private val getPromoUseCase: GetPromoUseCase,
    private val getPromoByIdUseCase: GetPromoByIdUseCase

) : ViewModel(){

    private val _promos = MutableLiveData<List<PromosItem>>()
    val promos : LiveData<List<PromosItem>> get() = _promos

    private val _promo = MutableLiveData<PromosItem>()
    val promo : LiveData<PromosItem> get() = _promo

    init {
        getPromos()
    }

    private fun getPromos(){
        viewModelScope.launch {
            try {

                val promos = getPromoUseCase()
                _promos.value = promos

            } catch (_: Exception) {}
        }
    }

    fun getPromosById(id : Int){

        viewModelScope.launch {

            try {

                val promo = getPromoByIdUseCase(id)
                _promo.value = promo

            } catch (_: Exception){}

        }

    }
}