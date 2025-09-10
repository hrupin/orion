package `in`.hrup.orion.domain.usecases.videos

import `in`.hrup.orion.data.repositories.db.tables.VideoDAO

object PublishUnpublishVideoUseCase {

    fun execute(id: Long, published: Boolean): Boolean {
        return if(published){
            VideoDAO.publish(id = id)
        }
        else{
            VideoDAO.unpublish(id = id)
        }
    }

}