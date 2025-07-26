package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object CreatePostUseCase {

    fun execute(post: PostImpl): Boolean {
        return PostDAO.insert(model = post) > 0
    }

}