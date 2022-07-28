package com.example.calculadora.model

import java.lang.Exception

open class NumeroModel {
    constructor();

     var Numero = mutableListOf<Double>()
     var Operacoes = mutableListOf<String>()
    public fun addNumero(numero : Double,operacao: String = "equal"){
        Numero.add(numero);
        Operacoes.add(operacao)
    }

    public fun getLastNumero() : Double{
        return if(Numero.size>0) {
            Numero[Numero.size-1]
        }else{
            0.0;
        }
    }

    public fun equal(valor : Double=0.0) : Double{
       var soma : Double = 0.0
        if(Numero.size>0){

            for(cont in Numero.size downTo 1)
            {


                if(Operacoes[cont-1]=="equal")
                {
                    if(Operacoes.size>1)
                    {
                        Operacoes[cont-1] = Operacoes[cont-2]
                    }
                }
                if(Operacoes[cont-1]=="multiplicacao" || Operacoes[cont-1]=="divisao")
                {
                    if(Numero.size<=1)
                    {
                        soma = 0.0
                    }else{
                        try
                        {
                            soma=Numero[cont-2]

                        }catch (e : Exception){
                            soma = Numero[cont-1]
                        }

                    }

                }

                soma = when (Operacoes[cont - 1]) {
                    "soma" -> soma + Numero[cont - 1]
                    "multiplicacao" ->  soma * valor
                    "subtracao" -> soma - Numero[cont - 1]
                    "divisao" ->  soma / valor
                    else -> Numero[cont-1]
                }
            }

            return soma
        }else{
            return 0.0
        }

    }
    public fun getLastOperacao() : String{
        if(Operacoes.size > 0){
            return Operacoes[Operacoes.size-1]
        }else{
            return "equal"
        }
    }

    public fun getHistorico() : List<Double>{
        return Numero
    }

    public fun clearNumeros()
    {
        Numero.clear();
        Operacoes.clear();
    }
}