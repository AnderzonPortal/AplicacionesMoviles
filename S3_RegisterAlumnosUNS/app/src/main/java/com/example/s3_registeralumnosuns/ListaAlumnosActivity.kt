package com.example.s3_registeralumnosuns

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaAlumnosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterAlumnos: AlumnoAdapter
    private lateinit var spinnerOrden: Spinner
    private var alumnos = MainActivity.listaAlumnos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alumnos)

        recyclerView = findViewById(R.id.recyclerViewAlumnos)
        spinnerOrden = findViewById(R.id.spinnerOrden)

        adapterAlumnos = AlumnoAdapter(alumnos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterAlumnos

        val opcionesOrden = arrayOf(
            "Código (ascendente)",
            "Código (descendente)",
            "Apellidos (A → Z)",
            "Apellidos (Z → A)"
        )

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesOrden)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOrden.adapter = spinnerAdapter

        spinnerOrden.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> alumnos.sortBy { it.codigo }
                    1 -> alumnos.sortByDescending { it.codigo }
                    2 -> alumnos.sortBy { it.apellidos }
                    3 -> alumnos.sortByDescending { it.apellidos }
                }
                adapterAlumnos.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
