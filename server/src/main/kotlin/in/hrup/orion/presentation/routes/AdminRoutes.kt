package `in`.hrup.orion.presentation.routes

import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.get
import io.ktor.server.sessions.set
import io.ktor.server.routing.routing
import io.ktor.server.html.respondHtml
import io.ktor.server.sessions.sessions
import io.ktor.server.application.Application
import io.ktor.server.response.respondRedirect
import io.ktor.server.request.receiveParameters
import `in`.hrup.orion.domain.usecases.auth.LoginUseCase
import `in`.hrup.orion.presentation.ui.layouts.authLayout
import `in`.hrup.orion.presentation.ui.screens.authScreen
import `in`.hrup.orion.domain.usecases.auth.GetUserSessionByUsernameUseCase
import `in`.hrup.orion.domain.utils.Tree
import `in`.hrup.orion.presentation.ui.layouts.adminLayout
import java.io.File

fun Application.adminRoutes() {

    routing {

        get("auth/login"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        get("auth"){
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        post("/auth") {
            var isSuccess = false
            val params = call.receiveParameters()
            val login = params["email"] ?: ""
            val password = params["password"] ?: ""
            isSuccess = LoginUseCase.execute(login = login, password = password)
            if (isSuccess) {
                val user = GetUserSessionByUsernameUseCase.execute(username = login)
                if(user != null) {
                    call.sessions.set(user)
                }
                call.respondRedirect("/dashboard")
            } else {
                call.respondHtml {
                    authLayout {
                        authScreen(isError = "Помилка авторизації!")
                    }
                }
            }
        }

        get("dashboard"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                adminLayout {
                    authScreen()
                }
            }
        }

        get("dashboard"){
            val rootDir = File("/путь/к/директории")
            val tree = Tree.build(file = rootDir)
            call.respondHtml {
                adminLayout {
                    authScreen()
                }
            }
        }

    }

}