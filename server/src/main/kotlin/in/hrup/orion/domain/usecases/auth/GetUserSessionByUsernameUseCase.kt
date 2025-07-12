package `in`.hrup.orion.domain.usecases.auth

import `in`.hrup.orion.presentation.routes.UserSession
import `in`.hrup.orion.data.repositories.db.tables.UserDAO

object GetUserSessionByUsernameUseCase {

    fun execute(username: String): UserSession? {
        val user =  UserDAO.fetchByUsername(username = username)
        if (user != null) {
            return UserSession(username = user.username, id = user.id)
        }
        return null
    }

}