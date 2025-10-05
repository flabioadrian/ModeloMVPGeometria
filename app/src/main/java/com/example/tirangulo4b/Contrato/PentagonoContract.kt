package com.example.tirangulo4b.Contrato

interface PentagonoContract {
    interface Modelo {
        fun area(lado: Float, apotema: Float): Float
        fun perimetro(lado: Float): Float
        fun valido(lado: Float, apotema: Float): Boolean
    }

    interface Vista {
        fun showAreaPentagono(area: Float)
        fun showPerimetroPentagono(perimetro: Float)
        fun showError(mensaje: String)
    }

    interface Presentador {
        fun calcularAreaPentagono(lado: Float, apotema: Float)
        fun calcularPerimetroPentagono(lado: Float)
    }
}