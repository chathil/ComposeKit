val implementation by configurations
val kapt by configurations
val androidTestImplementation by configurations

dependencies {
    implementation(com.example.composekit.buildsrc.Libs.Kotlin.stdlib)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Room.legacySupport)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.coreKtx)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.appcompat)

    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.material)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.tooling)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.layout)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.materialIconsExtended)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.uiUtil)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.runtime)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.foundation)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.compiler)

    implementation(com.example.composekit.buildsrc.Libs.Accompanist.insets)
    implementation(com.example.composekit.buildsrc.Libs.Accompanist.glide)
    implementation(com.example.composekit.buildsrc.Libs.Accompanist.pager)
    implementation(com.example.composekit.buildsrc.Libs.Accompanist.pagerIndicators)

    androidTestImplementation(com.example.composekit.buildsrc.Libs.AndroidX.Compose.uiTest)

    kapt(com.example.composekit.buildsrc.Libs.Hilt.hiltCompiler)
    implementation(com.example.composekit.buildsrc.Libs.Hilt.hiltAndroid)

    implementation(com.example.composekit.buildsrc.Libs.AndroidX.dataStore)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.navigation)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Activity.activityCompose)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.Lifecycle.runtimeKtx)
    implementation(com.example.composekit.buildsrc.Libs.AndroidX.fragmentKtx)

    implementation(com.example.composekit.buildsrc.Libs.material)

}