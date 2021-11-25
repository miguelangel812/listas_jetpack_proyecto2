package com.example.listas_jetpack_proyecto.data

import java.io.Serializable

data class Jugador (
    val id: Int,
    val nombre: String,
    val pos: String,
    val dorsal: String,
    val edad: String,
    var des: String,
    val jugImageId: Int = 0
):Serializable