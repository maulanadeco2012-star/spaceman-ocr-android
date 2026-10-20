plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.spacemanocr"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.spacemanocr.ocrnew"    minSdk = 23
        targetSdk = 35
        versionCode = 2
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("com.google.mlkit:text-recognition:16.0.1")
}

