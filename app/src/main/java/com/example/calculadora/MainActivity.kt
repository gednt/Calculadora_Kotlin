package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.calculadora.controller.AdicaoController
import com.example.calculadora.controller.DivisaoController
import com.example.calculadora.controller.MultiplicacaoController
import com.example.calculadora.controller.SubtracaoController
import com.example.calculadora.model.NumeroModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val numeroModel = NumeroModel();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initializes the numbers class
        //Initializes the button and delegates a click behavior.
        val btnSoma: Button = findViewById<View>(R.id.btnSoma) as Button
        btnSoma.setOnClickListener{
            soma(btnSoma);
        }

        val btnSubtracao: Button = findViewById<View>(R.id.btnSubtracao) as Button
        btnSubtracao.setOnClickListener{
            subtracao(btnSubtracao);
        }

        val btnMultiplicacao: Button = findViewById<View>(R.id.btnMultiplicacao) as Button
        btnMultiplicacao.setOnClickListener{
            multiplicacao(btnMultiplicacao);
        }

        val btnDivisao: Button = findViewById<View>(R.id.btnDivisao) as Button
        btnDivisao.setOnClickListener{
            divisao(btnDivisao);
        }

        val btnClear : Button = findViewById<View>(R.id.btnClear) as Button
        btnClear.setOnClickListener{
            limpar(btnClear);
        }

        val btnEqual : Button = findViewById<View>(R.id.btnEqual) as Button
        btnEqual.setOnClickListener{
            val numero = (findViewById<View>(R.id.numero) as EditText).text.toString()
            numeroModel.addNumero(numero.toDouble())
            numeroModel.equal(numero.toDouble())
            (findViewById<EditText>(R.id.numero) as EditText).setText( numeroModel.equal(numero.toDouble()).toString())
            addHistorico()
        }
    }
    fun addHistorico(){
        val adapter = ArrayAdapter(this,
            R.layout.listview_item, numeroModel.getHistorico())
        (findViewById<ListView>(R.id.lstViewHistorico) as ListView).adapter = adapter

        (findViewById<EditText>(R.id.numero) as EditText).selectAll();
    }

    fun soma (v : View)
    {
        val numero = (findViewById<View>(R.id.numero) as EditText).text.toString()
        Toast.makeText(this,(numero.toString()) , Toast.LENGTH_LONG).show();
        numeroModel.addNumero(numero.toDouble(),"soma")
        (findViewById<EditText>(R.id.numero) as EditText).setText( numeroModel.equal(numero.toDouble()).toString())
        addHistorico()



    }

    fun subtracao (v : View)
    {
        val numero = (findViewById<View>(R.id.numero) as EditText).text.toString()
        Toast.makeText(this,(numero.toString()) , Toast.LENGTH_LONG).show();
        numeroModel.addNumero(numero.toDouble(),"subtracao")
        (findViewById<EditText>(R.id.numero) as EditText).setText( numeroModel.equal(numero.toDouble()).toString())
        addHistorico()
    }
    fun multiplicacao (v : View)
    {
        val numero = (findViewById<View>(R.id.numero) as EditText).text.toString()
        Toast.makeText(this,(numero.toString()) , Toast.LENGTH_LONG).show();
        numeroModel.addNumero(numero.toDouble(),"multiplicacao")
        (findViewById<EditText>(R.id.numero) as EditText).setText( numeroModel.equal(numero.toDouble()).toString())
        addHistorico()
    }
    fun divisao (v : View)
    {
        val numero = (findViewById<View>(R.id.numero) as EditText).text.toString()
        Toast.makeText(this,(numero.toString()) , Toast.LENGTH_LONG).show();
        numeroModel.addNumero(numero.toDouble(),"divisao")
        (findViewById<EditText>(R.id.numero) as EditText).setText( numeroModel.equal(numero.toDouble()).toString())
        addHistorico()
    }

    fun limpar(v : View)
    {
        numeroModel.clearNumeros();
        addHistorico()
    }
}