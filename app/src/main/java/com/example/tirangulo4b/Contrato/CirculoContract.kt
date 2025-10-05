package com.example.tirangulo4b.Contrato

interface CirculoContract {
    interface Modelo {
        fun area(radio: Float): Float
        fun perimetro(radio: Float): Float
        fun valido(radio: Float): Boolean
    }

    interface Vista {
        fun showAreaCirculo(area: Float)
        fun showPerimetroCirculo(perimetro: Float)
        fun showError(mensaje: String)
    }

    interface Presentador {
        fun calcularAreaCirculo(radio: Float)
        fun calcularPerimetroCirculo(radio: Float)
    }
}