package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object FetchPagedVideosUseCase {

    fun execute(limit: Int, offset: Int, month: Int? = null, year: Int? = null, tag: String? = null): List<VideoImpl> {
        return VideoDAO.fetchPaged(limit = limit, offset = offset, month = month, year = year, tag = tag)
    }

}