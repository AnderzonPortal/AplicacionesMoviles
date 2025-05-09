package com.example.s3_registeralumnosuns

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtUsuario: EditText
    private lateinit var edtClave: EditText
    private lateinit var btnLogin: Button
    private lateinit var imgEye: ImageView

    // Datos de login predefinidos (ejemplo)
    private val usuarioCorrecto = "admin"  // Usuario
    private val claveCorrecta = "1234"  // Contraseña

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUsuario = findViewById(R.id.txtusuario)
        edtClave = findViewById(R.id.txtclave)
        btnLogin = findViewById(R.id.button)
        imgEye = findViewById(R.id.imgEye)

        imgEye.setOnClickListener {
            togglePasswordVisibility()
        }

        btnLogin.setOnClickListener {
            val usuario = edtUsuario.text.toString()
            val clave = edtClave.text.toString()

            if (usuario == usuarioCorrecto && clave == claveCorrecta) {
                // Login exitoso
                Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()

                // Navegar a MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()  // Finalizar LoginActivity para que no se quede en el stack de actividades
            } else {
                // Error en login
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Cambiar a modo oculto
            edtClave.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
            imgEye.setImageResource(R.drawable.baseline_eye_off)  // Ojo cerrado
        } else {
            // Cambiar a modo visible
            edtClave.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            imgEye.setImageResource(R.drawable.baseline_eye_open)  // Ojo abierto
        }
        isPasswordVisible = !isPasswordVisible
        edtClave.setSelection(edtClave.text.length)  // Mantener el cursor al final
    }
}
