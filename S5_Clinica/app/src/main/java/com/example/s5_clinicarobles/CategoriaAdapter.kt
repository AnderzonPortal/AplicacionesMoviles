package com.example.s5_clinicarobles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s5_clinicarobles.databinding.ItemCategoriaBinding

class CategoriaAdapter(
    private val categorias: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCategoriaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(nombre: String) {
            binding.nombreCategoria.text = nombre
            binding.root.setOnClickListener { onItemClick(nombre) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categorias[position])
    }

    override fun getItemCount(): Int = categorias.size
}
