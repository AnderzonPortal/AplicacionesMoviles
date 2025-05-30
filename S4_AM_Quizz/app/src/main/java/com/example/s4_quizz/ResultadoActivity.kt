package com.example.s4_quizz

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ResultadoActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView
    private lateinit var txtPuntos: TextView
    private lateinit var txtTocaContinuar: TextView
    private lateinit var imgUsuario: ImageView
    private lateinit var txtNombreUsuario: TextView
    private lateinit var txtPuntosEnTiempoReal: TextView
    private lateinit var imgResultado: ImageView
    private lateinit var layoutRoot: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Referencias UI
        txtResultado = findViewById(R.id.txtResultado)
        txtPuntos = findViewById(R.id.txtPuntos)
        txtTocaContinuar = findViewById(R.id.txtTocaContinuar)
        imgUsuario = findViewById(R.id.imgUsuario)
        txtNombreUsuario = findViewById(R.id.txtNombreUsuario)
        txtPuntosEnTiempoReal = findViewById(R.id.txtPuntosEnTiempoReal)
        imgResultado = findViewById(R.id.imgResultado)
        layoutRoot = findViewById(R.id.layoutRoot)

        val esCorrecto = intent.getBooleanExtra("esCorrecto", false)
        val puntosActuales = intent.getIntExtra("puntos", 0)
        val preguntaIndice = intent.getIntExtra("indice", 0)
        val usuario = intent.getStringExtra("usuario") ?: "Invitado"

        txtResultado.text = if (esCorrecto) "¡Buen trabajo!" else "¡Uy casi!"
        txtPuntos.text = if (esCorrecto) "+10 puntos" else "-10 puntos"
        txtPuntos.setTextColor(
            if (esCorrecto)
                resources.getColor(android.R.color.holo_green_dark)
            else
                resources.getColor(android.R.color.holo_red_dark)
        )
        imgResultado.setImageResource(if (esCorrecto) R.drawable.ic_check else R.drawable.ic_x)

        txtNombreUsuario.text = usuario
        txtPuntosEnTiempoReal.text = "Puntos: $puntosActuales"

        layoutRoot.setOnClickListener {
            val intent = Intent(this, BienvenidoActivity::class.java)
            intent.putExtra("puntos", puntosActuales)
            intent.putExtra("indice", preguntaIndice)
            intent.putExtra("usuario", usuario)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
