package com.example.calculadora.controller

class DivisaoController {
    fun divisao(valor : Double,valorAnterior :Double) : Double{

        if(valor.equals(0))
        {
            return 0.0
        }else{
            return valorAnterior / valor
        }

    }
}