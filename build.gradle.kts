buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    val kotlinVersion = "1.4.32"

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.android.tools.build:gradle:4.1.3")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    extra.apply {
        set("ktorVersion", "1.4.0")
        set("serializationVersion", "1.0.0-RC")
        set("koinVersion", "3.0.1-beta-1")
        set("coroutineVersion", "1.4.3")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}