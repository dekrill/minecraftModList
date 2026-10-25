package omstu.pin252t.ryazanov.ui.list

import androidx.compose.runtime.Immutable
import omstu.pin252t.ryazanov.model.Mod

@Immutable
data class ModListState(
    val mods: List<Mod> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
) {
    val filteredMods: List<Mod>
        get() = if (searchQuery.isBlank()) {
            mods
        } else {
            mods.filter { it.title.contains(searchQuery.trim(), ignoreCase = true) }
        }
}
