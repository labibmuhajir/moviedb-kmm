import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.github.labibmuhajir.moviedb"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check"
        )
    }
}

val config = rootProject.extra
val koinVersion = config.get("koinVersion") as String
val lifecycleVersion = "2.3.1"
val composeVersion = "1.0.0-beta04"
val accompanistVersion = "0.7.1"

dependencies {
    add(PLUGIN_CLASSPATH_CONFIGURATION_NAME, "androidx.compose.compiler:compiler:$composeVersion")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.activity:activity-compose:1.3.0-alpha06")

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
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
    implementation("io.coil-kt:coil:1.1.1")

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("com.google.accompanist:accompanist-coil:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")

    implementation(project(":shared"))
}