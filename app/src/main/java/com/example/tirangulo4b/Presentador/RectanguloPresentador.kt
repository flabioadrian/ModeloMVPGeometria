package com.example.tirangulo4b.Presentador

import com.example.tirangulo4b.Contrato.RectanguloContract
import com.example.tirangulo4b.Modelo.RectanguloModelo

class RectanguloPresentador(private val vista: RectanguloContract.Vista) : RectanguloContract.Presentador {

    private val modelo: RectanguloContract.Modelo = RectanguloModelo()

    override fun calcularAreaRectangulo(base: Float, altura: Float) {
        if (modelo.valido(base, altura)) {
            val area = modelo.area(base, altura)
            vista.showAreaRectangulo(area)
        } else {
            vista.showError("Base y altura deben ser mayores a 0")
        }
    }

    override fun calcularPerimetroRectangulo(base: Float, altura: Float) {
        if (modelo.valido(base, altura)) {
            val perimetro = modelo.perimetro(base, altura)
            vista.showPerimetroRectangulo(perimetro)
        } else {
            vista.showError("Base y altura deben ser mayores a 0")
        }
    }

    override fun esUnCuadrado(base: Float, altura: Float){
        if(modelo.valido(base, altura)){
            val tipo = modelo.esCuadrado(base, altura)
            vista.showTipo(tipo)
        } else {
            vista.showError("Base y altura deben ser mayores a 0");
        }
    }
}