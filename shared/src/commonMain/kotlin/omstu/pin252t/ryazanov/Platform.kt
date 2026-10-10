package omstu.pin252t.ryazanov

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform