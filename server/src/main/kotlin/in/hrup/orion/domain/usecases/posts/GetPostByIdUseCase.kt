package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object GetPostByIdUseCase {

    fun execute(id: Long): PostImpl? {
        return PostDAO.fetchById(id = id)
    }

}