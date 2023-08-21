package com.example.aplicationapi.domain

import com.example.aplicationapi.domain.items.PromosItem
import com.example.aplicationapi.repo.PromosRepository
import javax.inject.Inject

class GetPromoByIdUseCase @Inject constructor(private val promosRepository: PromosRepository){

    suspend operator fun invoke(id : Int) : PromosItem {
        return promosRepository.getPromoById(id)
    }
}