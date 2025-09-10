package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object CreateVideoUseCase {

    fun execute(video: VideoImpl): Boolean {
        return VideoDAO.insert(model = video) > 0
    }

}