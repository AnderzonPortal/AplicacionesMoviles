package com.example.s9_sharedpreferences

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputLayout

class UserProfileActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSaveProfile: Button
    private lateinit var buttonLoadProfile: Button
    private lateinit var textViewProfile: TextView
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper


    // Referencia al card que contendrá la información del perfil
    private lateinit var cardProfileInfo: MaterialCardView

    private lateinit var bloque1: LinearLayout
    private lateinit var bloque2: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Inicializar SharedPreferencesHelper
        sharedPreferencesHelper = SharedPreferencesHelper(this)

        // Inicializar vistas
        initViews()

        // Configurar listeners
        setupListeners()

        // Aplicar el tema guardado
        applySavedTheme()
    }

    private fun initViews() {
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSaveProfile = findViewById(R.id.buttonSaveProfile)
        buttonLoadProfile = findViewById(R.id.buttonLoadProfile)
        textViewProfile = findViewById(R.id.textViewProfile)

        bloque1 = findViewById(R.id.bloque1)
        bloque2 = findViewById(R.id.bloque2)

        // Inicializar el card que contendrá la información del perfil
        cardProfileInfo = findViewById(R.id.cardProfileInfo)
    }

    private fun setupListeners() {
        buttonSaveProfile.setOnClickListener {
            saveProfileData()
        }

        buttonLoadProfile.setOnClickListener {
            loadProfileData()
        }
    }

    private fun saveProfileData() {
        val name = editTextName.text.toString().trim()
        val age = editTextAge.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        if (name.isEmpty() || age.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Guardar datos en SharedPreferences
        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_USERNAME, name)
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_USER_AGE, age.toInt())
        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_USER_EMAIL, email)

        Toast.makeText(this, "Perfil guardado exitosamente", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfileData() {
        val name = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_USERNAME, "No disponible")
        val age = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_USER_AGE, 0)
        val email = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_USER_EMAIL, "No disponible")

        // Mostrar la información del perfil en el TextView
        val profileInfo = "Nombre: $name\nEdad: $age\nEmail: $email"
        textViewProfile.text = profileInfo

        // Hacer visible el card donde se muestra el perfil
        cardProfileInfo.visibility = View.VISIBLE  // Cambiar la visibilidad de "gone" a "visible"
    }

    private fun applySavedTheme() {
        // Obtener el valor del tema guardado (modo oscuro o claro)
        val isDarkMode = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_THEME_MODE, false)

        // Aplicar el tema
        applyTheme(isDarkMode)
    }

    private fun applyTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            // Modo oscuro
            window.decorView.setBackgroundColor(Color.DKGRAY)
            editTextName.setTextColor(Color.WHITE)
            editTextAge.setTextColor(Color.WHITE)
            editTextEmail.setTextColor(Color.WHITE)
            textViewProfile.setBackgroundColor(Color.argb(100, 241, 234, 246))
            textViewProfile.setTextColor(Color.WHITE)

            bloque1.setBackgroundColor(Color.argb(100, 241, 234, 246))
            bloque2.setBackgroundColor(Color.argb(100, 241, 234, 246))

            // Cambiar el color del perfil cargado
            cardProfileInfo.setCardBackgroundColor(Color.DKGRAY)
            textViewProfile.setTextColor(Color.WHITE)

        } else {
            // Modo claro
            window.decorView.setBackgroundColor(Color.WHITE)
            editTextName.setTextColor(Color.BLACK)
            editTextAge.setTextColor(Color.BLACK)
            editTextEmail.setTextColor(Color.BLACK)
            textViewProfile.setBackgroundColor(Color.LTGRAY)
            textViewProfile.setTextColor(Color.BLACK)

            bloque1.setBackgroundColor(Color.LTGRAY)
            bloque2.setBackgroundColor(Color.LTGRAY)

            // Cambiar el color del perfil cargado
            cardProfileInfo.setCardBackgroundColor(Color.WHITE)
            textViewProfile.setTextColor(Color.BLACK)
        }
    }
}
