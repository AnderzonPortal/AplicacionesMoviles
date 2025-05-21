package com.example.s4_quizz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoFinalActivity : AppCompatActivity() {

    private lateinit var txtPuntosFinales: TextView
    private lateinit var btnReiniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_final)

        txtPuntosFinales = findViewById(R.id.txtPuntosFinales)
        btnReiniciar = findViewById(R.id.btnReiniciar)

        // Obtener puntos totales
        val puntosFinales = intent.getIntExtra("puntosFinales", 0)
        txtPuntosFinales.text = "Puntos totales: $puntosFinales"

        // Redirigir a CategoriasActivity al presionar el botón
        btnReiniciar.setOnClickListener {
            val intent = Intent(this, CategoriasActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
