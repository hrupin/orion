package `in`.hrup.orion

import `in`.hrup.orion.data.repositories.db.DatabaseFactory
import `in`.hrup.orion.presentation.routes.adminRoutes
import `in`.hrup.orion.presentation.routes.apiRoutes
import `in`.hrup.orion.presentation.routes.configureSessionAuth
import `in`.hrup.orion.presentation.routes.configureSessionStorage
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.auth.Authentication
import io.ktor.server.engine.*
import io.ktor.server.http.content.CompressedFileType
import io.ktor.server.http.content.default
import io.ktor.server.http.content.files
import io.ktor.server.http.content.preCompressed
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticFiles
import io.ktor.server.http.content.staticResources
import io.ktor.server.http.content.staticRootFolder
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.path
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import java.io.File
import java.io.PrintStream
import io.ktor.server.plugins.cors.routing.*

fun main() {

    val out = PrintStream(System.out, true, "UTF-8")
    System.setOut(out)

    DatabaseFactory.init()

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureSessionStorage()

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }

    install(Authentication) {
        configureSessionAuth()
    }

    install(CORS) {
        allowHost("127.0.0.1:8081", schemes = listOf("http"))
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowHeader(HttpHeaders.ContentType)
        allowCredentials = true
    }

    apiRoutes()
    adminRoutes()

    routing {

        staticResources("/static", "static") {
            default("index.html")
            preCompressed(CompressedFileType.GZIP)
        }

        val frontendDir = File("/home/orion/www/.orion/site/dist")

        route("/{...}") {
            handle {
                val path = call.request.path().removePrefix("/")
                val file = File(frontendDir, path)

                println("[Static DEBUG] Запросили: /$path")
                println("[Static DEBUG] Файл: ${file.absolutePath} — exists: ${file.exists()}")

                if (file.exists() && file.isFile) {
                    call.respondFile(file)
                } else {
                    // fallback to index.html
                    val indexFile = File(frontendDir, "index.html")
                    println("[Static DEBUG] Fallback на index.html")
                    if (indexFile.exists()) {
                        call.respondFile(indexFile)
                    } else {
                        call.respond(HttpStatusCode.NotFound, "index.html not found")
                    }
                }
            }
        }

    }
}