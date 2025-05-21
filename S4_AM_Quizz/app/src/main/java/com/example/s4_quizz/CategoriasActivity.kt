package com.example.s4_quizz

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.util.*

class CategoriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        val txtNombreUsuario = findViewById<TextView>(R.id.txtNombreUsuario)
        val imgPerfil = findViewById<ImageView>(R.id.imgPerfil)

        val usuario = intent.getStringExtra("usuario") ?: "Usuario"

        val peruTime = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"))
        val hora = peruTime.get(Calendar.HOUR_OF_DAY)

        val saludo = when (hora) {
            in 0..11 -> "BUENOS DÍAS"
            in 12..17 -> "BUENAS TARDES"
            else -> "BUENAS NOCHES"
        }

        txtSaludo.text = saludo
        txtNombreUsuario.text = usuario
        imgPerfil.setImageResource(R.drawable.usuario)

        // Referencias a las tarjetas por sus IDs
        val cardAplicaciones = findViewById<CardView>(R.id.card_aplicaciones)
        val cardAlgoritmos = findViewById<CardView>(R.id.card_algoritmos)
        val cardGestion = findViewById<CardView>(R.id.card_gobierno)
        val cardRobotica = findViewById<CardView>(R.id.card_robotica)
        val cardSeguridad = findViewById<CardView>(R.id.card_seguridad)
        val cardTesis = findViewById<CardView>(R.id.card_tesis)

        // Click en "APLICACIONES MOVILES" abre BienvenidoActivity
        cardAplicaciones.setOnClickListener {
            val intent = Intent(this, BienvenidoActivity::class.java)
            intent.putExtra("usuario", usuario) // ✅ AGREGA ESTA LÍNEA
            startActivity(intent)
        }

        // Click en las demás tarjetas abre ProximamenteActivity
        val tarjetasProximamente = listOf(
            cardAlgoritmos,
            cardGestion,
            cardRobotica,
            cardSeguridad,
            cardTesis
        )

        for (tarjeta in tarjetasProximamente) {
            tarjeta.setOnClickListener {
                val intent = Intent(this, ProximamenteActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
