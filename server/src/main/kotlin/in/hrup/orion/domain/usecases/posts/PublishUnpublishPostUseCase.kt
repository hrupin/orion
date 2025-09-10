package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object PublishUnpublishPostUseCase {

    fun execute(id: Long, published: Boolean): Boolean{
        return if(published){
            PostDAO.publish(id = id)
        }
        else{
            PostDAO.unpublish(id = id)
        }
    }

}