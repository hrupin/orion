package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO
import `in`.hrup.orion.data.repositories.db.tables.VideoDAO
import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.domain.dto.VideosDTO

object FetchPagedVideosUseCase {

    fun execute(limit: Int, offset: Int, month: Int? = null, year: Int? = null, tag: String? = null): VideosDTO {
        //return VideoDAO.fetchPaged(limit = limit, offset = offset, month = month, year = year, tag = tag)
        val videosData = VideoDAO.fetchPaged(limit = limit, offset = offset, month = month, year = year, tag = tag)
        val videosCount = VideoDAO.count()
        val currentPage = if (limit > 0) {
            (offset / limit) + 1
        } else 1
        val totalPages = if (limit > 0) {
            ((videosCount + limit - 1) /limit).toInt()
        } else 1
        return VideosDTO(
            videos = videosData,
            count = videosCount,
            currentPage = currentPage,
            totalPages = totalPages,
        )
    }

}