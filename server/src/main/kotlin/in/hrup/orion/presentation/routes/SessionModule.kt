package `in`.hrup.orion.presentation.routes

import `in`.hrup.orion.domain.usecases.auth.GetUserSessionByUsernameUseCase
import `in`.hrup.orion.domain.usecases.user.GetUserByUsernameUseCase
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.AuthenticationConfig
import io.ktor.server.auth.UserIdPrincipal
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.cookie
import io.ktor.server.sessions.*
import kotlinx.serialization.Serializable

fun Application.configureSessionStorage() {
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
        }
    }
}

fun AuthenticationConfig.configureSessionAuth() {
    session<UserSession>("user_session") {
        validate { session ->
            if (session.username.isNotEmpty()) {

                println("SESSION => ${session.username}")

                val acc = GetUserSessionByUsernameUseCase.execute(username = session.username)
                if (acc != null) {
                    AccountContext.setAccount(account = acc)
                }
                UserIdPrincipal(session.username)
            } else {
                null
            }
        }
        challenge {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/auth/login")
        }
    }
}

@Serializable
data class UserSession(val username: String, val id: Long)

object AccountContext {
    private val threadLocalAccount = ThreadLocal<UserSession?>()

    fun setAccount(account: UserSession) {
        threadLocalAccount.set(account)
    }

    fun getAccount(): UserSession? = threadLocalAccount.get()

    fun clear() {
        threadLocalAccount.remove()
    }
}