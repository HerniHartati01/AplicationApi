package com.example.aplicationapi.domain.items

import com.example.aplicationapi.data.remote.models.Img
import com.example.aplicationapi.data.remote.models.PromosModel

data class PromosItem(
    val id: Int,
    val desc: String,
    val img: Img,
    val nama: String,
)

fun PromosModel.toPromosItem() = PromosItem(
    id,
    desc,
    img,
    nama)
