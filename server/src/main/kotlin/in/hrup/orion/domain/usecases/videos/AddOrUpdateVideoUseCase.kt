package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object AddOrUpdateVideoUseCase {

    fun execute(model: VideoImpl): Boolean {
        return if(model.id > 0){
            VideoDAO.update(model = model)
        }
        else{
            VideoDAO.insert(model = model) > 0
        }
    }

}