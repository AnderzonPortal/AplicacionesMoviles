package com.example.s4_quizz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuarioEditText = findViewById<EditText>(R.id.txtusuario)
        val iniciarButton = findViewById<Button>(R.id.button)

        iniciarButton.setOnClickListener {
            val usuario = usuarioEditText.text.toString().trim()

            if (usuario.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu usuario", Toast.LENGTH_SHORT).show()
            } else {
                // Crear el Intent para abrir SecondActivity
                val intent = Intent(this, CategoriasActivity::class.java)
                // Enviar el usuario al segundo Activity
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            }
        }
    }
}
