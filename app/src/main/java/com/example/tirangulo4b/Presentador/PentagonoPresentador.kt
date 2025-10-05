package com.example.tirangulo4b.Presentador

import com.example.tirangulo4b.Contrato.PentagonoContract
import com.example.tirangulo4b.Modelo.PentagonoModelo

class PentagonoPresentador(private val vista: PentagonoContract.Vista) : PentagonoContract.Presentador {

    private val modelo: PentagonoContract.Modelo = PentagonoModelo()

    override fun calcularAreaPentagono(lado: Float, apotema: Float) {
        if (modelo.valido(lado, apotema)) {
            val area = modelo.area(lado, apotema)
            vista.showAreaPentagono(area)
        } else {
            vista.showError("Lado y apotema deben ser mayores a 0")
        }
    }

    override fun calcularPerimetroPentagono(lado: Float) {
        if (lado > 0) {
            val perimetro = modelo.perimetro(lado)
            vista.showPerimetroPentagono(perimetro)
        } else {
            vista.showError("El lado debe ser mayor a 0")
        }
    }
}