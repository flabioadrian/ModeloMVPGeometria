package com.example.tirangulo4b.Modelo

import com.example.tirangulo4b.Contrato.CirculoContract
import kotlin.math.PI

class CirculoModelo : CirculoContract.Modelo {
    override fun area(radio: Float): Float {
        return (PI * radio * radio).toFloat()
    }

    override fun perimetro(radio: Float): Float {
        return (2 * PI * radio).toFloat()
    }

    override fun valido(radio: Float): Boolean {
        return radio > 0
    }
}