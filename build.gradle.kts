// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Hilt.hiltGradlePlugin)
        classpath(Libs.Kotlin.serializationPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}


plugins {
    id("com.diffplug.spotless").version("5.12.4")
}

subprojects {
    repositories {
        google()
        mavenCentral()
//        maven {
//            setUrl(Urls.maven)
//        }
    }
    apply {
        plugin("com.diffplug.spotless")
    }
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")
            ktlint(Versions.ktlint)
//            licenseHeaderFile rootProject.file('spotless/copyright.kt') /* add copyright header */
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            // Treat all Kotlin warnings as errors
            allWarningsAsErrors = true

            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"

            // Enable experimental coroutines APIs, including Flow
            freeCompilerArgs =
                freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.FlowPreview"
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.Experimental"

            // Set JVM target to 1.8
            jvmTarget = "1.8"
        }
    }
    // androidx.test and hilt are forcing JUnit, 4.12. This forces them to use 4.13
    configurations.configureEach {
        resolutionStrategy {
            force(Libs.junit)
        }
    }
}
