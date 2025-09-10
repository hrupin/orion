package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object RemoveVideoByIdUseCase {

    fun execute(id: Long): Boolean {
        return VideoDAO.remove(id = id)
    }

}