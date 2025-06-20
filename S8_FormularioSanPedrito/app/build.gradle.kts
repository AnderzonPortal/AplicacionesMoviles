plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.s8_formulariosanpedrito"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.s8_formulariosanpedrito"
        minSdk = 31        // Cambiado de 35 a 31
        targetSdk = 35     // Puedes dejarlo en 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Dependencias necesarias para androidx
    implementation(libs.androidx.core.ktx) // KTX para usar las extensiones de Kotlin
    implementation(libs.androidx.appcompat) // Para usar Toolbar, Activity, y componentes de la appcompat
    implementation(libs.material) // Material Design Components
    implementation(libs.androidx.activity) // Activity KTX para soporte de la actividad
    implementation(libs.androidx.constraintlayout) // Para usar ConstraintLayout
    implementation(libs.firebase.inappmessaging) // Firebase In-App Messaging (si lo usas)

    // Test dependencies
    testImplementation(libs.junit) // JUnit para pruebas unitarias
    androidTestImplementation(libs.androidx.junit) // Para pruebas de Android usando JUnit
    androidTestImplementation(libs.androidx.espresso.core) // Para pruebas de UI con Espresso
}
