package omstu.pin252t.ryazanov.model

data class ModDependency(
    val id: String,
    val name: String
)

data class Mod(
    val id: String,
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val author: String,
    val iconUrl: String,
    val downloads: Long,
    val follows: Long,
    val loaders: List<String>,
    val gameVersions: List<String>,
    val dependencies: List<ModDependency> = emptyList()
)
