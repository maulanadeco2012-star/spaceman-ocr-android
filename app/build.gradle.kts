
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.spacemanocr"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.spacemanocr"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation("com.google.mlkit:text-recognition:16.0.1")
}
