package omstu.pin252t.ryazanov.navigation

import androidx.navigation3.runtime.NavKey

sealed interface Screen : NavKey {
    data object ModList : Screen
    data class ModDetail(val modId: String) : Screen
}