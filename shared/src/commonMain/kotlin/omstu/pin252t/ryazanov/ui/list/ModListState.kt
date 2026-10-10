package omstu.pin252t.ryazanov.ui.list

import androidx.compose.runtime.Immutable
import omstu.pin252t.ryazanov.model.Mod

@Immutable
data class ModListState(
    val mods: List<Mod> = emptyList(),
    val isLoading: Boolean = false
)