package com.example.s8_formulariosanpedrito

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchTheme: Switch = findViewById(R.id.switchTheme)

        // Obtener el estado guardado del tema desde SharedPreferences
        val sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("isDarkMode", false)

        // Ajustar el switch según el estado actual
        switchTheme.isChecked = isDarkMode

        // Cambiar entre los modos claro y oscuro cuando el switch cambie
        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Modo oscuro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Modo claro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            // Guardar el estado del tema en SharedPreferences
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("isDarkMode", isChecked)
            editor.apply()

            // Reinicia la actividad para aplicar el nuevo tema
            recreate()
        }
    }
}
