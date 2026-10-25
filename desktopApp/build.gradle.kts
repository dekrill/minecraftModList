import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(project(":shared"))

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)
    implementation(libs.coil.network.okhttp)

    implementation(libs.compose.uiToolingPreview)
}

compose.desktop {
    application {
        mainClass = "omstu.pin252t.ryazanov.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "omstu.pin252t.ryazanov"
            packageVersion = "1.0.0"
        }
    }
}