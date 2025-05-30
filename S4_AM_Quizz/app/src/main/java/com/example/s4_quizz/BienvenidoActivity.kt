package com.example.s4_quizz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class BienvenidoActivity : AppCompatActivity() {

    private lateinit var txtContador: TextView
    private lateinit var txtPregunta: TextView
    private lateinit var txtRespuesta1: TextView
    private lateinit var txtRespuesta2: TextView
    private lateinit var txtRespuesta3: TextView
    private lateinit var txtRespuesta4: TextView

    private lateinit var cardRespuesta1: CardView
    private lateinit var cardRespuesta2: CardView
    private lateinit var cardRespuesta3: CardView
    private lateinit var cardRespuesta4: CardView

    private var indicePregunta = 0
    private var puntos = 0
    private var puedeResponder = true
    private var timer: CountDownTimer? = null

    private val preguntas = PreguntasProvider.listaPreguntas


    private var usuario: String = "Invitado"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        txtContador = findViewById(R.id.txtContador)
        txtPregunta = findViewById(R.id.txtPregunta)
        txtRespuesta1 = findViewById(R.id.txtRespuesta1)
        txtRespuesta2 = findViewById(R.id.txtRespuesta2)
        txtRespuesta3 = findViewById(R.id.txtRespuesta3)
        txtRespuesta4 = findViewById(R.id.txtRespuesta4)

        cardRespuesta1 = findViewById(R.id.cardRespuesta1)
        cardRespuesta2 = findViewById(R.id.cardRespuesta2)
        cardRespuesta3 = findViewById(R.id.cardRespuesta3)
        cardRespuesta4 = findViewById(R.id.cardRespuesta4)

        puntos = intent.getIntExtra("puntos", 0)
        indicePregunta = intent.getIntExtra("indice", 0)

        usuario = intent.getStringExtra("usuario") ?: "Invitado"

        configurarEventos()
    }

    override fun onResume() {
        super.onResume()
        if (indicePregunta < preguntas.size) {
            mostrarPregunta()
            iniciarContador()
            puedeResponder = true
        } else {
            val intent = Intent(this, ResultadoFinalActivity::class.java)
            intent.putExtra("puntosFinales", puntos)
            startActivity(intent)
            finish()
        }
    }

    private fun iniciarContador() {
        timer?.cancel()

        val duracion = 30_000L
        timer = object : CountDownTimer(duracion, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val segundos = (millisUntilFinished / 1000).toInt()
                txtContador.text = segundos.toString()
            }

            override fun onFinish() {
                if (puedeResponder) {
                    puedeResponder = false
                    verificarRespuesta(-1)
                }
            }
        }.start()
    }

    private fun mostrarPregunta() {
        val pregunta = preguntas[indicePregunta]
        txtPregunta.text = pregunta.texto
        txtRespuesta1.text = pregunta.opciones[0]
        txtRespuesta2.text = pregunta.opciones[1]
        txtRespuesta3.text = pregunta.opciones[2]
        txtRespuesta4.text = pregunta.opciones[3]
        resetearColores()
    }

    private fun configurarEventos() {
        val opciones = listOf(
            cardRespuesta1 to 0,
            cardRespuesta2 to 1,
            cardRespuesta3 to 2,
            cardRespuesta4 to 3
        )

        for ((card, index) in opciones) {
            card.setOnClickListener {
                if (puedeResponder) {
                    puedeResponder = false
                    verificarRespuesta(index)
                }
            }
        }
    }

    private fun verificarRespuesta(indiceSeleccionado: Int) {
        val correcta = preguntas[indicePregunta].respuestaCorrecta

        if (indiceSeleccionado == correcta) {
            pintarTarjetaCorrecta(indiceSeleccionado)
            puntos += 10
        } else {
            if (indiceSeleccionado != -1) {
                pintarTarjetaIncorrecta(indiceSeleccionado)
            }
            pintarTarjetaCorrecta(correcta)
            puntos -= 10
        }

        cardRespuesta1.postDelayed({
            navegarResultado(indiceSeleccionado == correcta)
        }, 1500)
    }

    private fun pintarTarjetaCorrecta(indice: Int) {
        val verde = Color.parseColor("#4CAF50")
        when (indice) {
            0 -> txtRespuesta1.setBackgroundColor(verde)
            1 -> txtRespuesta2.setBackgroundColor(verde)
            2 -> txtRespuesta3.setBackgroundColor(verde)
            3 -> txtRespuesta4.setBackgroundColor(verde)
        }
    }

    private fun pintarTarjetaIncorrecta(indice: Int) {
        val rojo = Color.parseColor("#F44336")
        when (indice) {
            0 -> txtRespuesta1.setBackgroundColor(rojo)
            1 -> txtRespuesta2.setBackgroundColor(rojo)
            2 -> txtRespuesta3.setBackgroundColor(rojo)
            3 -> txtRespuesta4.setBackgroundColor(rojo)
        }
    }

    private fun resetearColores() {
        val color = Color.parseColor("#E0E3ED")
        txtRespuesta1.setBackgroundColor(color)
        txtRespuesta2.setBackgroundColor(color)
        txtRespuesta3.setBackgroundColor(color)
        txtRespuesta4.setBackgroundColor(color)
    }

    private fun navegarResultado(esCorrecto: Boolean) {
        timer?.cancel()

        if (indicePregunta >= preguntas.size) {
            val intent = Intent(this, ResultadoFinalActivity::class.java)
            intent.putExtra("puntosFinales", puntos)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("esCorrecto", esCorrecto)
            intent.putExtra("puntos", puntos)
            intent.putExtra("indice", indicePregunta + 1)

            // PASAR EL USUARIO AL RESULTADO ACTIVITY
            intent.putExtra("usuario", usuario)

            startActivity(intent)
            finish()
        }
    }
}
