package com.example.s5_clinicarobles

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s5_clinicarobles.databinding.ItemEspecialidadBinding

class EspecialidadAdapter(private var especialidades: List<Especialidad>) :
    RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemEspecialidadBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(especialidad: Especialidad) {
            val medico = especialidad.medicos.firstOrNull() ?: "Sin médico"
            binding.nombreEspecialidad.text = especialidad.nombre
            binding.medicoResponsable.text = medico
            binding.horario.text = especialidad.horario

            val imagen = when {
                medico.startsWith("Dra.", ignoreCase = true) ||
                        medico.startsWith("Lic. ", ignoreCase = true) -> R.drawable.doctora
                else -> R.drawable.doctor
            }
            binding.icono.setImageResource(imagen)

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("nombre", medico)
                    putExtra("especialidad", especialidad.nombre)
                    putExtra("horario", especialidad.horario)
                    putExtra("imagenResId", imagen)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEspecialidadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(especialidades[position])
    }

    override fun getItemCount(): Int = especialidades.size

    fun updateList(nuevaLista: List<Especialidad>) {
        especialidades = nuevaLista
        notifyDataSetChanged()
    }
}
