package com.example.tirangulo4b.Modelo

import com.example.tirangulo4b.Contrato.RectanguloContract

class RectanguloModelo : RectanguloContract.Modelo {
    override fun area(base: Float, altura: Float): Float {
        return base * altura
    }

    override fun perimetro(base: Float, altura: Float): Float {
        return 2 * (base + altura)
    }

    override fun esCuadrado(base: Float, altura: Float): String {
        return if(base == altura) "Cuadrado" else "Rectangulo"
    }

    override fun valido(base: Float, altura: Float): Boolean {
        return base > 0 && altura > 0
    }
}