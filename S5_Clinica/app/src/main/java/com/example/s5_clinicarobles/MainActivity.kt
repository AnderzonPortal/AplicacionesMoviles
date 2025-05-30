package com.example.s5_clinicarobles

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.s5_clinicarobles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var especialidadAdapter: EspecialidadAdapter
    private lateinit var categoriaAdapter: CategoriaAdapter

    private var listaVisible = false
    private lateinit var todasLasEspecialidades: List<Especialidad>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar datos de especialidades
        todasLasEspecialidades = EspecialidadData.getEspecialidades()
        val nombresUnicos = todasLasEspecialidades.map { it.nombre }.distinct()

        // Adaptador del grid de categorías
        categoriaAdapter = CategoriaAdapter(nombresUnicos) { categoria ->
            val seleccionados = todasLasEspecialidades.firstOrNull { it.nombre == categoria }

            // Expande cada médico en una tarjeta separada
            val listaExpandida = seleccionados?.medicos?.map {
                Especialidad(
                    nombre = categoria,
                    medicos = listOf(it),
                    horario = seleccionados.horario,
                    iconoResId = seleccionados.iconoResId
                )
            } ?: emptyList()

            especialidadAdapter.updateList(listaExpandida)

            // Cerrar grid y mostrar cards
            listaVisible = false
            binding.contenedorCategorias.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            binding.tituloEspecialidades.text = "Especialidades ▼"
        }

        binding.recyclerCategorias.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerCategorias.adapter = categoriaAdapter
        binding.contenedorCategorias.visibility = View.GONE

        // Botón para mostrar/ocultar categorías
        binding.tituloEspecialidades.setOnClickListener {
            listaVisible = !listaVisible
            if (listaVisible) {
                binding.contenedorCategorias.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
                binding.tituloEspecialidades.text = "Especialidades ▲"
            } else {
                binding.contenedorCategorias.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                binding.tituloEspecialidades.text = "Especialidades ▼"
            }
        }

        // Mostrar todos los médicos en tarjetas individuales al iniciar
        val listaInicialExpandida = todasLasEspecialidades.flatMap { especialidad ->
            especialidad.medicos.map { medico ->
                Especialidad(
                    nombre = especialidad.nombre,
                    medicos = listOf(medico),
                    horario = especialidad.horario,
                    iconoResId = especialidad.iconoResId
                )
            }
        }

        especialidadAdapter = EspecialidadAdapter(listaInicialExpandida)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = especialidadAdapter
        binding.recyclerView.visibility = View.VISIBLE
    }
}
