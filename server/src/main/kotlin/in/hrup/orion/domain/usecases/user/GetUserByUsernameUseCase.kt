package `in`.hrup.orion.domain.usecases.user

import `in`.hrup.orion.data.repositories.db.tables.UserDAO
import `in`.hrup.orion.domain.models.User

object GetUserByUsernameUseCase {

    fun execute(username: String): User? {
        return UserDAO.fetchByUsername(username = username)
    }

}