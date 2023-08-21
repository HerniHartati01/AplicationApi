package com.example.aplicationapi.domain

import com.example.aplicationapi.domain.items.PromosItem
import com.example.aplicationapi.repo.PromosRepository
import javax.inject.Inject

class GetPromoUseCase @Inject constructor(private val promosRepository: PromosRepository
) {

    suspend operator fun  invoke() : List<PromosItem>{
        return promosRepository.getPromo().shuffled()
    }

}