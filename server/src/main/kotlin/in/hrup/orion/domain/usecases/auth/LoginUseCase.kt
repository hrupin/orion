package `in`.hrup.orion.domain.usecases.auth

import `in`.hrup.orion.data.modelsImpl.UserImpl
import `in`.hrup.orion.data.repositories.db.tables.UserDAO
import `in`.hrup.orion.domain.utils.MD5

object LoginUseCase {

    fun execute(login: String, password: String): Boolean {
        println("login: - " +UserDAO.checkByUserNameAndPassword(username = login, password = MD5.getFromString("$login:$password")))
        return UserDAO.checkByUserNameAndPassword(username = login, password = MD5.getFromString("$login:$password"))
    }

}