package `in`.hrup.orion.domain.usecases.category

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.repositories.db.tables.CategoryDAO

object AddOrUpdateCategoryUseCase {

    fun execute(model: CategoryImpl): Boolean {
        return if(model.id > 0){
            CategoryDAO.update(model = model)
        }
        else{
            CategoryDAO.insert(model = model) > 0
        }
    }

}