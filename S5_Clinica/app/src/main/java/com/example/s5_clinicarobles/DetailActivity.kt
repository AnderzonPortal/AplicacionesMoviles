package com.example.s5_clinicarobles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.s5_clinicarobles.databinding.ActivityDetailBinding
import kotlin.random.Random

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val frases = listOf(
        "“Tu salud es mi prioridad.”",
        "“Aquí para cuidarte siempre.”",
        "“Confía en nosotros, confía en tu bienestar.”",
        "“Juntos por una vida saludable.”",
        "“Atención con calidad y calidez.”"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val especialidad = intent.getStringExtra("especialidad")
        val horario = intent.getStringExtra("horario")
        val imagenResId = intent.getIntExtra("imagenResId", R.drawable.doctor)

        binding.nombreDoctor.text = nombre
        binding.especialidadDoctor.text = "Especialidad: $especialidad"
        binding.fotoDoctor.setImageResource(imagenResId)

        val fraseAleatoria = frases[Random.nextInt(frases.size)]
        binding.fraseDoctor.text = fraseAleatoria

        binding.botonAgendar.setOnClickListener {
            Toast.makeText(this, "¡Cita agendada con $nombre!", Toast.LENGTH_SHORT).show()
        }
    }
}
