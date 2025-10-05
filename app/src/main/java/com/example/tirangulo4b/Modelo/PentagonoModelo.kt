package com.example.tirangulo4b.Modelo

import com.example.tirangulo4b.Contrato.PentagonoContract

class PentagonoModelo : PentagonoContract.Modelo {
    override fun area(lado: Float, apotema: Float): Float {
        val perimetro = perimetro(lado)
        return (perimetro * apotema) / 2
    }

    override fun perimetro(lado: Float): Float {
        return 5 * lado
    }

    override fun valido(lado: Float, apotema: Float): Boolean {
        return lado > 0 && apotema > 0
    }
}