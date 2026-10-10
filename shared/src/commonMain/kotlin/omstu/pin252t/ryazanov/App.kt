package omstu.pin252t.ryazanov

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import omstu.pin252t.ryazanov.navigation.AppNavigation

@Composable
fun App() {
    var isDarkTheme by remember { mutableStateOf(false) }
    var currentLanguage by remember { mutableStateOf("ru") }

    val colorScheme = if (isDarkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(colorScheme = colorScheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            key(currentLanguage) {
                AppNavigation(
                    isDarkTheme = isDarkTheme,
                    currentLanguage = currentLanguage,
                    onToggleTheme = { isDarkTheme = !isDarkTheme },
                    onToggleLanguage = {
                        val newLang = if (currentLanguage == "ru") "en" else "ru"
                        setAppLocale(newLang)
                        currentLanguage = newLang
                    }
                )
            }
        }
    }
}