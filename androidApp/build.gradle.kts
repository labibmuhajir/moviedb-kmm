plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

val config = rootProject.extra
val koinVersion = config.get("koinVersion") as String
val lifecycleVersion = "2.3.1"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("com.google.android.material:material:1.4.0-alpha02")
    implementation("androidx.fragment:fragment-ktx:1.3.2")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.coil-kt:coil:1.1.1")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.github.labibmuhajir.moviedb.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}