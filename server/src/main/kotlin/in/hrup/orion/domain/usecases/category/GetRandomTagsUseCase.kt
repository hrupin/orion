package `in`.hrup.orion.domain.usecases.category

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object GetRandomTagsUseCase {

    fun execute(): List<String>{
        return PostDAO.fetchRandomTags()
    }

}