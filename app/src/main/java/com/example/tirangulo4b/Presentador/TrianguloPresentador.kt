package com.example.tirangulo4b.Presentador

import com.example.tirangulo4b.Contrato.TrianguloContract
import com.example.tirangulo4b.Modelo.TrianguloModelo

class TrianguloPresentador(private val vista: TrianguloContract.Vista) : TrianguloContract.Presentador {

    private val modelo: TrianguloContract.Modelo = TrianguloModelo()

    override fun area(l1: Float, l2: Float, l3: Float) {
        if(modelo.valido(l1,l2,l3)){
            val s = modelo.area(l1,l2,l3)
            vista.showArea(s)
        }else
            vista.showError("Datos no validos")
    }

    override fun perimetro(l1: Float, l2: Float, l3: Float) {
        if(modelo.valido(l1,l2,l3)){
            val p = modelo.perimetro(l1,l2,l3)
            vista.showPerimetro(p)
        }else
            vista.showError("Datos no validos")
    }

    override fun tipo(l1: Float, l2: Float, l3: Float) {
        if(modelo.valido(l1,l2,l3)){
            val t = modelo.tipo(l1,l2,l3)
            vista.showTipo(t)
        }else
            vista.showError("Datos no validos")
    }
}