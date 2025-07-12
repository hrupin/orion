package `in`.hrup.orion

import `in`.hrup.orion.data.repositories.db.DatabaseFactory
import `in`.hrup.orion.presentation.routes.adminRoutes
import `in`.hrup.orion.presentation.routes.configureSessionAuth
import `in`.hrup.orion.presentation.routes.configureSessionStorage
import io.ktor.server.application.*
import io.ktor.server.auth.Authentication
import io.ktor.server.engine.*
import io.ktor.server.http.content.CompressedFileType
import io.ktor.server.http.content.default
import io.ktor.server.http.content.preCompressed
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {

    DatabaseFactory.init()

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureSessionStorage()

    install(Authentication) {
        configureSessionAuth()
    }

    adminRoutes()

    routing {

        staticResources("/static", "static") {
            default("index.html")
            preCompressed(CompressedFileType.GZIP)
        }

        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }

    }
}