package com.example.calculadorasimples

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {
    var operacao: Int = 0
    var numero1: Double = 0.0

    lateinit var txNum1: TextView
    lateinit var txNum2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        txNum1 = findViewById(R.id.inputOperacao)
        txNum2 = findViewById(R.id.resultado)
        val cleanBtn: Button = findViewById(R.id.limparBtn)
        var resultBtn: Button = findViewById(R.id.igualBtn)

        cleanBtn.setOnClickListener {
            txNum1.setText("")
            txNum2.setText("")
            numero1 = 0.0
            operacao = 0
        }

        resultBtn.setOnClickListener {
            var numero2: Double = txNum2.text.toString().toDouble()
            var result: Double = 0.0

            when(operacao){
                1 -> result = numero1 + numero2
                2 -> result = numero1 - numero2
                3 -> result = numero1 * numero2
                4 -> result = numero1 / numero2
            }

            txNum2.setText(result.toString())

            txNum1.setText("")
        }
    }

    fun cliqueBtn(view: View) {
        var num2: String = txNum2.text.toString()

        when(view.id) {
            R.id.btn0 -> txNum2.setText(num2 + "0")
            R.id.btn1 -> txNum2.setText(num2 + "1")
            R.id.btn2 -> txNum2.setText(num2 + "2")
            R.id.btn3 -> txNum2.setText(num2 + "3")
            R.id.btn4 -> txNum2.setText(num2 + "4")
            R.id.btn5 -> txNum2.setText(num2 + "5")
            R.id.btn6 -> txNum2.setText(num2 + "6")
            R.id.btn7 -> txNum2.setText(num2 + "7")
            R.id.btn8 -> txNum2.setText(num2 + "8")
            R.id.btn9 -> txNum2.setText(num2 + "9")
            R.id.pontoBtn -> txNum2.setText(num2 + ".")
        }
    }

    fun cliqueOperacao(view: View) {
        numero1 = txNum2.text.toString().toDouble()

        var num2_text: String = txNum2.text.toString()

        txNum2.setText("")

        when(view.id){
            R.id.somaBtn -> {
                txNum1.setText(num2_text + "+")
                operacao = 1
            }

            R.id.subtracaoBtn -> {
                txNum1.setText(num2_text + "-")
                operacao = 2
            }

            R.id.multiplicacaoBtn -> {
                txNum1.setText(num2_text + "*")
                operacao = 3
            }

            R.id.divisaoBtn -> {
                txNum1.setText(num2_text + "/")
                operacao = 4
            }
        }
    }
}