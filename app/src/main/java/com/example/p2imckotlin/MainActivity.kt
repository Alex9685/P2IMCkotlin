package com.example.p2imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var pesoEditText: EditText
    private lateinit var alturaEditText: EditText
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesoEditText = findViewById(R.id.pesoEditText)
        alturaEditText = findViewById(R.id.alturaEditText)
        resultadoTextView = findViewById(R.id.resultadoTextView)

        val calcularButton: Button = findViewById(R.id.calcularButton)
        calcularButton.setOnClickListener {
            calcularIMC()
        }

        val borrarButton: Button = findViewById(R.id.borrarButton)
        borrarButton.setOnClickListener {
            borrarCampos()
        }

        val salirButton: Button = findViewById(R.id.salirButton)
        salirButton.setOnClickListener {
            finish()
        }
    }

    private fun calcularIMC() {
        val peso: Double = pesoEditText.text.toString().toDoubleOrNull() ?: 0.0
        val altura: Double = alturaEditText.text.toString().toDoubleOrNull() ?: 0.0

        if (peso != 0.0 && altura != 0.0) {
            val imc: Double = peso / (altura * altura)
            resultadoTextView.text = String.format(" Tu IMC es: %.2f", imc)
        } else {
            resultadoTextView.text = ""
        }
    }

    private fun borrarCampos() {
        pesoEditText.setText("")
        alturaEditText.setText("")
        resultadoTextView.setText("")
    }
}
