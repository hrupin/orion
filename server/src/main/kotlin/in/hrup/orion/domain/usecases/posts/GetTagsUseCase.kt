package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object GetTagsUseCase {

    fun execute(): List<String>{
        return PostDAO.fetchTags()
    }

}