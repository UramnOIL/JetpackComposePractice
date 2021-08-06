buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
    }
}

plugins {
    kotlin("multiplatform") version "1.5.21" apply false
    id("org.jetbrains.compose") version "0.5.0-build270" apply false
}

group = "com.uramnoil"
version = "1.0"

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}