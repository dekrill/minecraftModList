package omstu.pin252t.ryazanov.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import omstu.pin252t.ryazanov.data.mockMods
import omstu.pin252t.ryazanov.ui.detail.ModDetailScreen
import omstu.pin252t.ryazanov.ui.detail.ModDetailState
import omstu.pin252t.ryazanov.ui.list.ModListScreen
import omstu.pin252t.ryazanov.ui.list.ModListState

@Composable
fun AppNavigation(
    isDarkTheme: Boolean,
    currentLanguage: String,
    onToggleTheme: () -> Unit,
    onToggleLanguage: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backStack = remember { mutableStateListOf<Screen>(Screen.ModList) }

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeAt(backStack.lastIndex)
            }
        },
        transitionSpec = {
            (slideInHorizontally(initialOffsetX = { it }) + fadeIn()) togetherWith
                    (slideOutHorizontally(targetOffsetX = { -it }) + fadeOut())
        },
        popTransitionSpec = {
            (slideInHorizontally(initialOffsetX = { -it }) + fadeIn()) togetherWith
                    (slideOutHorizontally(targetOffsetX = { it }) + fadeOut())
        },
        entryProvider = { screen ->
            val contentKey = when (screen) {
                is Screen.ModList -> "mod_list"
                is Screen.ModDetail -> "mod_detail_${screen.modId}"
            }
            NavEntry(
                key = screen,
                contentKey = contentKey
            ) {
                when (screen) {
                    is Screen.ModList -> {
                        val state = remember { ModListState(mods = mockMods) }
                        ModListScreen(
                            state = state,
                            onModClick = { modId ->
                                backStack.add(Screen.ModDetail(modId))
                            },
                            topBarActions = {
                                androidx.compose.material3.TextButton(onClick = onToggleLanguage) {
                                    androidx.compose.material3.Text(
                                        text = currentLanguage.uppercase(),
                                        style = androidx.compose.material3.MaterialTheme.typography.labelLarge
                                    )
                                }
                                androidx.compose.material3.IconButton(onClick = onToggleTheme) {
                                    androidx.compose.material3.Text(
                                        text = "◐"
                                    )
                                }
                            }
                        )
                    }
                    is Screen.ModDetail -> {
                        val mod = remember(screen.modId) {
                            mockMods.find { it.id == screen.modId }
                        }
                        val state = remember(mod) { ModDetailState(mod = mod) }
                        ModDetailScreen(
                            state = state,
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeAt(backStack.lastIndex)
                                }
                            },
                            onOpenDependency = { depId ->
                                backStack.add(Screen.ModDetail(depId))
                            }
                        )
                    }
                }
            }
        }
    )
}