package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object FetchPagedPostsUseCase {

    fun execute(limit: Int, offset: Int, month: Int?, year: Int?, category: String?, tag: String?): PostsDTO {
        val postsData = PostDAO.fetchPaged(limit = limit, offset = offset, month = month, year = year, category = category, tag = tag)
        val postsCount = PostDAO.count()
        val currentPage = if (limit > 0) {
            (offset / limit) + 1
        } else 1
        val totalPages = if (limit > 0) {
            ((postsCount + limit - 1) /limit).toInt()
        } else 1
        return PostsDTO(
            posts = postsData,
            count = postsCount,
            currentPage = currentPage,
            totalPages = totalPages,
        )
    }

}