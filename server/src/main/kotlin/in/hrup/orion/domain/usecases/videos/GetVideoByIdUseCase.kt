package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object GetVideoByIdUseCase {

    fun execute(id: Long): VideoImpl? {
        return VideoDAO.fetchById(id = id)
    }

}