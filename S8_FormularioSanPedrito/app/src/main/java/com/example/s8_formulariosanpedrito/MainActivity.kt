package com.example.s8_formulariosanpedrito

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.widget.PopupMenu
import android.view.Menu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verificar el estado del tema desde SharedPreferences y aplicar
        val sharedPreferences: SharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("isDarkMode", false)

        // Aplicar el modo de tema almacenado (claro u oscuro)
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val spinnerTipo = findViewById<Spinner>(R.id.spinnerTipo)
        val layoutCodigoEstudiante = findViewById<LinearLayout>(R.id.layoutCodigoEstudiante)
        val etCodigoEstudiante = findViewById<EditText>(R.id.etCodigoEstudiante)
        val cbConfirmacion = findViewById<CheckBox>(R.id.cbConfirmacion)
        val cbTransporte = findViewById<CheckBox>(R.id.cbTransporte)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)

        // Definir las opciones para el spinner
        val tiposParticipante = arrayOf("Alumno", "Docente", "Personal Administrativo")

        // Crear el adaptador con el estilo personalizado para los ítems del Spinner
        val adapter = ArrayAdapter(this, R.layout.spinner_item, tiposParticipante)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipo.adapter = adapter

        // Implementación de OnItemSelectedListener
        spinnerTipo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val tipo = tiposParticipante[position]
                layoutCodigoEstudiante.visibility = if (tipo == "Alumno") View.VISIBLE else View.GONE
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Acción para el botón Confirmar
        btnConfirmar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val apellidos = etApellidos.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()
            val tipo = spinnerTipo.selectedItem.toString()
            val confirmacion = cbConfirmacion.isChecked
            val transporte = cbTransporte.isChecked
            val codigoEstudiante = etCodigoEstudiante.text.toString().trim()

            if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos obligatorios (*)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (tipo == "Alumno" && codigoEstudiante.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu código de estudiante", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!confirmacion) {
                Toast.makeText(this, "Debes confirmar tu participación para continuar.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mostrar resumen de la información ingresada
            val resumen = "Registro confirmado:\n" +
                    "Nombre: $nombre $apellidos\n" +
                    "Correo: $correo\n" +
                    "Teléfono: ${if (telefono.isNotEmpty()) telefono else "No proporcionado"}\n" +
                    "Tipo: $tipo\n" +
                    "Código de Estudiante: ${if (tipo == "Alumno") codigoEstudiante else "No requerido"}\n" +
                    "Transporte: ${if (transporte) "Sí" else "No"}"

            Toast.makeText(this, resumen, Toast.LENGTH_LONG).show()
        }

        // Agregar un Popup Menu para el menú de opciones
        val btnShowMenu: Button = findViewById(R.id.btnShowMenu)

        btnShowMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, btnShowMenu)
            menuInflater.inflate(R.menu.popu_menu, popupMenu.menu)  // Usamos el popup_menu.xml

            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.popup_webview -> {
                        val intent = Intent(this, WebViewActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.popup_settings -> {
                        val intent = Intent(this, SettingsActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show() // Mostrar el Popup Menu
        }
    }

    // Mostrar mensaje Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Cargar el menú en la actividad (ya no es necesario, lo hemos movido al PopupMenu)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false // No es necesario cargar el menú aquí
    }

    // Ya no se necesita este método ya que el PopupMenu lo maneja
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
