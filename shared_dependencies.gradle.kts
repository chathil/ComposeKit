val implementation by configurations
val kapt by configurations
val androidTestImplementation by configurations

dependencies {
    implementation(com.example.composekit.buildsrc.Libs.Kotlin.stdlib)
    implementation(com.example.composekit.buildsrc.Libs.store)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.appcompat)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.coreKtx)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Room.legacySupport)

    implementation(com.example.composekit.buildsrc.Libs.Coroutines.core)
    implementation(com.example.composekit.buildsrc.Libs.Coroutines.android)
    implementation(com.example.composekit.buildsrc.Libs.Coroutines.test)
    implementation(com.example.composekit.buildsrc.Libs.Coroutines.playServices)

    kapt(com.example.composekit.buildsrc.Libs.Hilt.hiltCompiler)
    implementation(com.example.composekit.buildsrc.Libs.Hilt.hiltAndroid)

    androidTestImplementation(com.example.composekit.buildsrc.Libs.junit)
    androidTestImplementation(com.example.composekit.buildsrc.Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(com.example.composekit.buildsrc.Libs.AndroidX.Test.core)
    androidTestImplementation(com.example.composekit.buildsrc.Libs.AndroidX.Test.rules)
    androidTestImplementation(com.example.composekit.buildsrc.Libs.AndroidX.Test.espressoCore)

    // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13.2
    configurations.configureEach {
        resolutionStrategy {
            force(com.example.composekit.buildsrc.Libs.junit)
        }
    }
}