package `in`.hrup.orion.domain.usecases.posts

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO

object AddOrUpdatePostUseCase {

    fun execute(model: PostImpl): Boolean {
        return if(model.id > 0){
            PostDAO.update(model = model)
        }
        else{
            PostDAO.insert(model = model) > 0
        }
    }

}