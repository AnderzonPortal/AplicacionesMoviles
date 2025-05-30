package com.example.s4_quizz

data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)
