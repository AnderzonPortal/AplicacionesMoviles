package com.example.s3_registeralumnosuns

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AlumnoAdapter(private var lista: MutableList<Alumno>) :
    RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>() {

    class AlumnoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCodigo: TextView = view.findViewById(R.id.txtCodigo)
        val txtApellidos: TextView = view.findViewById(R.id.txtApellidos)
        val txtNombres: TextView = view.findViewById(R.id.txtNombres)
        val txtCorreo: TextView = view.findViewById(R.id.txtCorreo)
        val txtAvatar: TextView = view.findViewById(R.id.txtAvatar)
        val btnEliminar: View = view.findViewById(R.id.btnEliminar) // Cambiado a View
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumno, parent, false)
        return AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val alumno = lista[position]

        holder.txtCodigo.text = "Código: ${alumno.codigo}"
        holder.txtApellidos.text = "Apellidos: ${alumno.apellidos}"
        holder.txtNombres.text = "Nombres: ${alumno.nombres}"
        holder.txtCorreo.text = "Correo: ${alumno.correo}"

        val iniciales = (alumno.nombres.split(" ").firstOrNull()?.take(1) ?: "") +
                (alumno.apellidos.split(" ").firstOrNull()?.take(1) ?: "")
        holder.txtAvatar.text = iniciales.uppercase()

        holder.btnEliminar.setOnClickListener {
            val context = holder.itemView.context
            AlertDialog.Builder(context)
                .setTitle("Eliminar alumno")
                .setMessage("¿Deseas eliminar a ${alumno.nombres} ${alumno.apellidos}?")
                .setPositiveButton("Sí") { _, _ -> eliminarAlumno(holder.adapterPosition, context) }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }

    override fun getItemCount(): Int = lista.size

    fun actualizarLista(nuevaLista: List<Alumno>) {
        lista = nuevaLista.toMutableList()
        notifyDataSetChanged()
    }

    private fun eliminarAlumno(position: Int, context: android.content.Context) {
        lista.removeAt(position)  // Eliminar el alumno de la lista
        notifyItemRemoved(position)  // Notificar el cambio
        Toast.makeText(context, "Alumno eliminado", Toast.LENGTH_SHORT).show()
    }
}
