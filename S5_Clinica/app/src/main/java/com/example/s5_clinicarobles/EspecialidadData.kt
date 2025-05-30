package com.example.s5_clinicarobles

object EspecialidadData {
    fun getEspecialidades(): List<Especialidad> {
        return listOf(
            Especialidad("Traumatología", listOf(
                "Dr. Alberto García Cerna",
                "Dr. Cruz Medina Martínez",
                "Dr. Edison Abanto Arroyo",
                "Dra. Sandra Robles Zanelli",
                "Dra. Yessenia Zapata Delgado",
                "Dr. Ciro Madrid Flores",
                "Dr. Pablo Mego"
            ), "Lunes a Viernes, 8:00 - 17:00", R.drawable.ic_especialidad_default),

            Especialidad("Cardiología", listOf(
                "Dr. Roberto Chavesta Bernal"
            ), "Lunes a Viernes, 9:00 - 15:00", R.drawable.ic_especialidad_default),

            Especialidad("Cirugía Cardiovascular", listOf(
                "Dr. Romel Zamudio Silva"
            ), "Martes y Jueves, 10:00 - 14:00", R.drawable.ic_especialidad_default),

            Especialidad("Cirugía General", listOf(
                "Dr. Beto Miranda Sevillano",
                "Dr. Pool Jara Pesantes",
                "Dr. Jonnatan Uribe",
                "Dr. Beltrany Lavado"
            ), "Lunes a Sábado, 8:00 - 13:00", R.drawable.ic_especialidad_default),

            Especialidad("Dermatología", listOf(
                "Dr. Jaime Vega Chavez",
                "Dr. Italo Vegas Jaramillo"
            ), "Lunes a Viernes, 14:00 - 18:00", R.drawable.ic_especialidad_default),

            Especialidad("Endocrinología", listOf(
                "Dr. Juan Pinto Sanchez"
            ), "Miércoles y Viernes, 10:00 - 13:00", R.drawable.ic_especialidad_default),

            Especialidad("Gastroenterología", listOf(
                "Dra. Kelly Casanova Lau"
            ), "Lunes a Viernes, 8:00 - 12:00", R.drawable.ic_especialidad_default),

            Especialidad("Ginecología", listOf(
                "Dr. Jose Luis Espinoza Decena",
                "Dra. Yulissa Paredes Padilla",
                "Dr. Julio Ostolaza Rodríguez",
                "Dra. Leslie Sosa De La Cruz"
            ), "Lunes a Viernes, 9:00 - 17:00", R.drawable.ic_especialidad_default),

            Especialidad("Medicina Física", listOf(
                "Dr. Luis Vasquez"
            ), "Lunes a Viernes, 13:00 - 17:00", R.drawable.ic_especialidad_default),

            Especialidad("Medicina General", listOf(
                "Dr. Elwis Laveriano Hoyos",
                "Dra. Maria Cristina Saavedra"
            ), "Lunes a Domingo, 8:00 - 20:00", R.drawable.ic_especialidad_default),

            Especialidad("Medicina Interna", listOf(
                "Dr. Luis Cabrera Ciprian",
                "Dra. Rosa Casimiro Lau",
                "Dra. Yuriko Zuñiga Lavado"
            ), "Lunes a Viernes, 9:00 - 15:00", R.drawable.ic_especialidad_default),

            Especialidad("Neumología", listOf(
                "Dra. Yessica Montoya Caldas",
                "Dr. Walter Centurion Jaramillo"
            ), "Lunes a Viernes, 14:00 - 18:00", R.drawable.ic_especialidad_default),

            Especialidad("Neurocirugía", listOf(
                "Dr. Willy Caballero Grados"
            ), "Martes y Jueves, 11:00 - 15:00", R.drawable.ic_especialidad_default),

            Especialidad("Neurología", listOf(
                "Dr. Rosnel Valdivieso Velarde"
            ), "Lunes a Miércoles, 10:00 - 13:00", R.drawable.ic_especialidad_default),

            Especialidad("Nutrición", listOf(
                "Lic. Carmela Carbajal"
            ), "Lunes a Viernes, 9:00 - 12:00", R.drawable.ic_especialidad_default),

            Especialidad("Odontología", listOf(
                "Dr. Pedro Cipriano Alegre",
                "Dra. Carolina Acuña Calderón"
            ), "Lunes a Sábado, 8:00 - 14:00", R.drawable.ic_especialidad_default),

            Especialidad("Cirugía Maxilofacial", listOf(
                "Dr. Julio Robles Zanelli"
            ), "Martes y Viernes, 10:00 - 13:00", R.drawable.ic_especialidad_default),

            Especialidad("Otorrino", listOf(
                "Dr. Jorge Bonillo Vargas"
            ), "Lunes a Viernes, 9:00 - 13:00", R.drawable.ic_especialidad_default),

            Especialidad("Oftalmología", listOf(
                "Dra. Anita Vigo Arroyo"
            ), "Lunes a Viernes, 13:00 - 18:00", R.drawable.ic_especialidad_default),

            Especialidad("Pediatría", listOf(
                "Dr. Marcos Vasquez Tantas",
                "Dr. Jaime Cabrera Pereda",
                "Dr. Hugo Melendez Cuentas",
                "Dr. Juan Solis Angeles",
                "Dra. Rosa Angeldionis Hurtado",
                "Dr. Edward Ramirez Alvear",
                "Dr. Fernando Samame",
                "Dra. Ana Lopez",
                "Dr. Jose Lozano"
            ), "Lunes a Sábado, 8:00 - 16:00", R.drawable.ic_especialidad_default),

            Especialidad("Psicología", listOf(
                "Lic. Astrid Manrique Marron",
                "Lic. Luz Vasquez Burgos"
            ), "Lunes a Viernes, 10:00 - 17:00", R.drawable.ic_especialidad_default),

            Especialidad("Psiquiatría", listOf(
                "Dra. Celmira Lazaro Loyola"
            ), "Miércoles y Viernes, 9:00 - 12:00", R.drawable.ic_especialidad_default),

            Especialidad("Reumatología", listOf(
                "Dr. Frank Ocaña Vasquez"
            ), "Lunes a Miércoles, 14:00 - 18:00", R.drawable.ic_especialidad_default),

            Especialidad("Urología", listOf(
                "Dr. Carlos Morales Flores",
                "Dr. Luis Pascual Plasencia",
                "Dr. Jose Acosta Fuentes"
            ), "Lunes a Viernes, 13:00 - 17:00", R.drawable.ic_especialidad_default)
        )
    }
}
