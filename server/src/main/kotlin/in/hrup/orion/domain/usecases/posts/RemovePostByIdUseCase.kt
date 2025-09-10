package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object RemovePostByIdUseCase {

    fun execute(id: Long): Boolean{
        return PostDAO.remove(id = id)
    }

}