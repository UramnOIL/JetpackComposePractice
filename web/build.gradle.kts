import org.jetbrains.compose.compose

// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

// Enable JS(IR) target and add dependencies
kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.web.widgets)
                implementation(compose.runtime)
            }
        }
    }
}

compose.web {
}