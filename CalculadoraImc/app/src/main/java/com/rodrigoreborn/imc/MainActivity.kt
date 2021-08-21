package com.rodrigoreborn.imc

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

     var pinicial = 0
     var pfinal = 0

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekbarPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { pesoresultadoseek.text = progress.toString() }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { if (seekBar != null) { pinicial = seekBar.progress } }

            override fun onStopTrackingTouch(seekBar: SeekBar?) { if (seekBar != null) { pfinal = seekBar.progress } }
        })
        calcular.setOnClickListener {
            val height = Altura.text.toString().toDouble()
            val rImc = resultado
            val imc = seekbarPeso.progress / (height * height)

            // rImc = ao textview "resultado"
            //height = ao editText "Altura"
            if (imc <= 18.5) {
                rImc.text = "Seu IMC é: \n $imc \n Abaixo do Peso "
                rImc.setTextColor(Color.RED)
            } else if (imc > 18.5 && imc <= 24.9) {
                rImc.text = "Seu IMC é: \n $imc \n  Peso Normal"
                rImc.setTextColor(Color.GREEN)
            } else if (imc > 24.9 && imc <= 29.9) {
                rImc.text = "Seu IMC é: \n $imc \n Acima do Peso"
                rImc.setTextColor(Color.YELLOW)
            } else if (imc > 29.9 && imc <= 34.9) {
                rImc.text = "Seu IMC é: \n $imc \n Obesidade Grau I "
                rImc.setTextColor(Color.YELLOW)
            } else if (imc > 34.9 && imc <= 39.9) {
                rImc.text = "Seu IMC é: \n $imc \n Obesidade Grau II"
                rImc.setTextColor(Color.YELLOW)
            } else if (imc > 40.0) {
                rImc.text = "Seu IMC é: \n $imc \n Obesidade Grau III ou Mórbida"
                rImc.setTextColor(Color.RED)
            }
        }
    }
}