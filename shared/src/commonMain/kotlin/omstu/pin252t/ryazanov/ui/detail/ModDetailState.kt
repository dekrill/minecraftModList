package omstu.pin252t.ryazanov.ui.detail

import androidx.compose.runtime.Immutable
import omstu.pin252t.ryazanov.model.Mod

@Immutable
data class ModDetailState(
    val mod: Mod? = null,
    val isLoading: Boolean = false
)