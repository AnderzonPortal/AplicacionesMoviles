package com.example.s4_quizz

class PreguntasProvider {
    companion object {
        val listaPreguntas = listOf(
            Pregunta(
                texto = "¿Qué función cumple el archivo AndroidManifest.xml?",
                opciones = listOf(
                    "Diseña la interfaz",
                    "Declara componentes y permisos de la app",
                    "Define el tamaño de las vistas",
                    "Almacena imágenes"
                ),
                respuestaCorrecta = 1
            ),
            Pregunta(
                texto = "¿Cómo se vincula una Activity con su diseño XML?",
                opciones = listOf(
                    "Mediante un intent",
                    "Con la etiqueta <layout>",
                    "Usando setContentView(R.layout.nombre)",
                    "Asociando un botón"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué diferencia hay entre wrap_content y match_parent?",
                opciones = listOf(
                    "Una usa más memoria",
                    "Una ajusta al padre, otra al contenido",
                    "Una es solo para texto",
                    "No hay diferencia"
                ),
                respuestaCorrecta = 1
            ),
            Pregunta(
                texto = "¿Qué ventaja tiene ConstraintLayout sobre layouts anidados?",
                opciones = listOf(
                    "Ocupa menos RAM",
                    "Se ve mejor en dispositivos antiguos",
                    "Permite una jerarquía más plana y eficiente",
                    "Requiere menos código Java"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué componente se debe usar para campos de entrada de texto?",
                opciones = listOf(
                    "TextView",
                    "EditText",
                    "Label",
                    "Button"
                ),
                respuestaCorrecta = 1
            ),
            Pregunta(
                texto = "¿Cuál es la función principal de un ViewGroup?",
                opciones = listOf(
                    "Agregar estilos",
                    "Mostrar imágenes",
                    "Contener y organizar otras vistas",
                    "Ejecutar acciones"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué propiedad en EditText muestra un texto guía temporal?",
                opciones = listOf(
                    "id",
                    "text",
                    "inputType",
                    "hint"
                ),
                respuestaCorrecta = 3
            ),
            Pregunta(
                texto = "¿Qué vista permite mostrar listas extensas de datos?",
                opciones = listOf(
                    "ImageView",
                    "ScrollView",
                    "RecyclerView",
                    "FrameLayout"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Cuál es una ventaja del editor visual de Android Studio?",
                opciones = listOf(
                    "Elimina errores automáticamente",
                    "No requiere código",
                    "Permite diseñar sin escribir XML",
                    "Solo funciona con ConstraintLayout"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué atributo se usa para distribuir el espacio en LinearLayout?",
                opciones = listOf(
                    "layout_width",
                    "layout_weight",
                    "layout_alignParent",
                    "layout_gravity"
                ),
                respuestaCorrecta = 1
            ),
            Pregunta(
                texto = "¿Por qué es importante usar sp para textos?",
                opciones = listOf(
                    "Asegura una unidad absoluta",
                    "Evita desbordamientos",
                    "Escala el texto según la preferencia del usuario",
                    "Aumenta la velocidad de carga"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué componente muestra contenido cuando la pantalla es más pequeña que el layout?",
                opciones = listOf(
                    "ConstraintLayout",
                    "LinearLayout",
                    "ScrollView",
                    "CardView"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué relación tiene TextView con View en Android?",
                opciones = listOf(
                    "No tiene relación",
                    "TextView hereda de View",
                    "TextView contiene a View",
                    "View solo existe en XML"
                ),
                respuestaCorrecta = 1
            ),
            Pregunta(
                texto = "¿Qué define un Layout en un archivo XML?",
                opciones = listOf(
                    "Lógica de negocio",
                    "Interacciones del usuario",
                    "Estructura y posición de los elementos",
                    "Conexión entre Activities"
                ),
                respuestaCorrecta = 2
            ),
            Pregunta(
                texto = "¿Qué componente permite mostrar una imagen desde un recurso?",
                opciones = listOf(
                    "EditText",
                    "ViewGroup",
                    "ImageView",
                    "LinearLayout"
                ),
                respuestaCorrecta = 2
            )
        )
    }
}
