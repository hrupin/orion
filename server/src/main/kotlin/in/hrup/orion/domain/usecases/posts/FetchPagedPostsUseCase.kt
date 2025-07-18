package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object FetchPagedPostsUseCase {

    fun execute(limit: Int, offset: Int, month: Int?, year: Int?, tag: String?): List<PostImpl> {
        return PostDAO.fetchPaged(limit = limit, offset = offset, month = month, year = year, tag = tag)
    }

}