package com.example.tirangulo4b.Contrato

interface RectanguloContract {
    interface Modelo {
        fun area(base: Float, altura: Float): Float
        fun perimetro(base: Float, altura: Float): Float
        fun esCuadrado(base: Float, altura: Float): String
        fun valido(base: Float, altura: Float): Boolean
    }

    interface Vista {
        fun showAreaRectangulo(area: Float)
        fun showPerimetroRectangulo(perimetro: Float)
        fun showError(mensaje: String)

        fun showTipo(tipo : String)
    }

    interface Presentador {
        fun calcularAreaRectangulo(base: Float, altura: Float)
        fun calcularPerimetroRectangulo(base: Float, altura: Float)

        fun esUnCuadrado(base: Float, altura: Float)
    }
}