package com.example.s9_sharedpreferences

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var editTextUsername: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonLoad: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonResetCounter: Button
    private lateinit var buttonGoToProfile: Button
    private lateinit var textViewResult: TextView
    private lateinit var textViewWelcome: TextView
    private lateinit var textViewConfiguracion: TextView
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var mainLayout: CoordinatorLayout

    // Agregar referencias a los bloques
    private lateinit var bloque1: LinearLayout  // Bloque adicional a cambiar de color
    private lateinit var bloque2: LinearLayout  // Bloque adicional a cambiar de color
    private lateinit var bloque3: LinearLayout  // Bloque adicional a cambiar de color
    private lateinit var bloque4: LinearLayout  // Bloque adicional a cambiar de color

    // Referencia al TextInputLayout
    private lateinit var textInputLayout: TextInputLayout  // Agregar TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Aplicar los márgenes para los bordes del sistema (barra de estado, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar SharedPreferencesHelper
        sharedPreferencesHelper = SharedPreferencesHelper(this)

        // Inicializar vistas
        initViews()

        // Configurar listeners
        setupListeners()

        // Incrementar y mostrar el contador de visitas
        incrementVisitCounter()

        // Verificar si es la primera vez que se abre la app
        checkFirstTime()

        // Aplicar tema guardado
        applySavedTheme()
    }

    private fun initViews() {
        editTextUsername = findViewById(R.id.editTextUsername)
        buttonSave = findViewById(R.id.buttonSave)
        buttonLoad = findViewById(R.id.buttonLoad)
        buttonClear = findViewById(R.id.buttonClear)
        buttonResetCounter = findViewById(R.id.buttonResetCounter)
        buttonGoToProfile = findViewById(R.id.buttonGoToProfile)
        textViewResult = findViewById(R.id.textViewResult)
        switchDarkMode = findViewById(R.id.switchDarkMode)
        mainLayout = findViewById(R.id.main)
        textViewWelcome = findViewById(R.id.textViewWelcome)
        textViewConfiguracion= findViewById(R.id.textViewConfiguracion)

        // Referencia al bloque que deseas cambiar de color
        bloque1 = findViewById(R.id.bloque1)
        bloque2 = findViewById(R.id.bloque2)
        bloque3 = findViewById(R.id.bloque3)
        bloque4 = findViewById(R.id.bloque4)

        // Referencia al TextInputLayout
        textInputLayout = findViewById(R.id.textfield)  // Asegúrate de que el ID esté correcto
    }

    private fun setupListeners() {
        buttonSave.setOnClickListener {
            saveData()
        }

        buttonLoad.setOnClickListener {
            loadData()
        }

        buttonClear.setOnClickListener {
            clearAllData()
        }

        buttonResetCounter.setOnClickListener {
            resetVisitCounter()
        }

        buttonGoToProfile.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_THEME_MODE, isChecked)
            applyTheme(isChecked)
        }
    }

    private fun saveData() {
        val username = editTextUsername.text.toString().trim()

        if (username.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_USERNAME, username)
        sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, false)
        sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_USER_ID, (1000..9999).random())

        Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show()
        editTextUsername.setText("")
    }

    private fun loadData() {
        val username = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_USERNAME, "Sin nombre")
        val isFirstTime = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, true)
        val userId = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_USER_ID, 0)

        val result = "Usuario: $username\nID: $userId\nPrimera vez: ${if (isFirstTime) "Sí" else "No"}"
        textViewResult.text = result
    }

    private fun clearAllData() {
        sharedPreferencesHelper.clearAll()
        textViewResult.text = ""
        editTextUsername.setText("")
        Toast.makeText(this, "Todas las preferencias han sido eliminadas", Toast.LENGTH_SHORT).show()
    }

    private fun checkFirstTime() {
        val isFirstTime = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, true)

        if (isFirstTime) {
            Toast.makeText(this, "¡Bienvenido por primera vez!", Toast.LENGTH_LONG).show()
        }
    }

    private fun incrementVisitCounter() {
        var visitCount = sharedPreferencesHelper.getVisitCount()
        visitCount++
        sharedPreferencesHelper.saveVisitCount(visitCount)
        textViewResult.text = "Visitas: $visitCount"
    }

    private fun resetVisitCounter() {
        sharedPreferencesHelper.saveVisitCount(0)
        textViewResult.text = "Visitas: 0"
        Toast.makeText(this, "Contador de visitas reseteado", Toast.LENGTH_SHORT).show()
    }

    private fun applySavedTheme() {
        val isDarkMode = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_THEME_MODE, false)
        switchDarkMode.isChecked = isDarkMode
        applyTheme(isDarkMode)
    }

    private fun applyTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            mainLayout.setBackgroundColor(Color.DKGRAY)
            editTextUsername.setTextColor(Color.WHITE)
            editTextUsername.setHintTextColor(Color.LTGRAY)
            textViewResult.setTextColor(Color.WHITE)
            switchDarkMode.setTextColor(Color.WHITE)
            buttonGoToProfile.setTextColor(Color.WHITE)
            buttonResetCounter.setTextColor(Color.WHITE)
            buttonClear.setTextColor(Color.WHITE)
            textViewWelcome.setTextColor(Color.WHITE)
            textViewConfiguracion.setTextColor(Color.WHITE)

            bloque1.setBackgroundColor(Color.argb(100, 241, 234, 246))
            bloque2.setBackgroundColor(Color.argb(100, 241, 234, 246))
            bloque3.setBackgroundColor(Color.argb(100, 241, 234, 246))
            bloque4.setBackgroundColor(Color.argb(100, 241, 234, 246))

            // Aplicando color al TextInputLayout
            textInputLayout.setHintTextColor(Color.WHITE)
            editTextUsername.setTextColor(Color.WHITE)

        } else {
            mainLayout.setBackgroundColor(Color.WHITE)
            editTextUsername.setTextColor(Color.BLACK)
            editTextUsername.setHintTextColor(Color.BLACK)
            textViewResult.setTextColor(Color.BLACK)
            switchDarkMode.setTextColor(Color.BLACK)
            buttonGoToProfile.setTextColor(Color.BLACK)
            buttonResetCounter.setTextColor(Color.BLACK)
            buttonClear.setTextColor(Color.BLACK)
            textViewWelcome.setTextColor(Color.BLACK)
            textViewConfiguracion.setTextColor(Color.BLACK)

            // Cambiar el color a los bloques
            bloque1.setBackgroundColor(Color.LTGRAY)
            bloque2.setBackgroundColor(Color.LTGRAY)
            bloque3.setBackgroundColor(Color.LTGRAY)
            bloque4.setBackgroundColor(Color.LTGRAY)

            // Resetear el color del TextInputLayout
            textInputLayout.setHintTextColor(Color.BLACK)  // Establecer color de hint a negro en modo claro
            editTextUsername.setHintTextColor(Color.BLACK)  // Establecer color de texto a negro en modo claro
        }

        Log.d("MainActivity", "onCreate: Activity started")
    }
}

private fun TextInputLayout.setHintTextColor(i: Int) {}
