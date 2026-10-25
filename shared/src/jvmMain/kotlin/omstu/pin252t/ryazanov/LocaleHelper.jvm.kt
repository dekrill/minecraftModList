package omstu.pin252t.ryazanov

import java.util.Locale

actual fun setAppLocale(language: String) {
    Locale.setDefault(Locale.forLanguageTag(language))
}
