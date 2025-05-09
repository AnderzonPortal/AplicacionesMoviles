package com.example.s3_registeralumnosuns

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object {
        val listaAlumnos = mutableListOf<Alumno>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCodigo = findViewById<EditText>(R.id.editCodigo)
        val editApellidos = findViewById<EditText>(R.id.editApellidos)
        val editNombres = findViewById<EditText>(R.id.editNombres)
        val editCorreo = findViewById<EditText>(R.id.editCorreo)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnVerRegistros = findViewById<Button>(R.id.btnVerRegistros)

        btnRegistrar.setOnClickListener {
            val alumno = Alumno(
                editCodigo.text.toString(),
                editApellidos.text.toString(),
                editNombres.text.toString(),
                editCorreo.text.toString()
            )
            listaAlumnos.add(alumno)
            editCodigo.text.clear()
            editApellidos.text.clear()
            editNombres.text.clear()
            editCorreo.text.clear()
        }

        btnVerRegistros.setOnClickListener {
            startActivity(Intent(this, ListaAlumnosActivity::class.java))
        }
    }
}
