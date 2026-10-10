package omstu.pin252t.ryazanov

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "minecraftModList",
    ) {
        App()
    }
}