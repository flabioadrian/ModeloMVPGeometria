package com.example.tirangulo4b.Presentador

import com.example.tirangulo4b.Contrato.CirculoContract
import com.example.tirangulo4b.Modelo.CirculoModelo

class CirculoPresentador(private val vista: CirculoContract.Vista) : CirculoContract.Presentador {

    private val modelo: CirculoContract.Modelo = CirculoModelo()

    override fun calcularAreaCirculo(radio: Float) {
        if (modelo.valido(radio)) {
            val area = modelo.area(radio)
            vista.showAreaCirculo(area)
        } else {
            vista.showError("El radio debe ser mayor a 0")
        }
    }

    override fun calcularPerimetroCirculo(radio: Float) {
        if (modelo.valido(radio)) {
            val perimetro = modelo.perimetro(radio)
            vista.showPerimetroCirculo(perimetro)
        } else {
            vista.showError("El radio debe ser mayor a 0")
        }
    }
}