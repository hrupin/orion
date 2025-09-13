package `in`.hrup.orion.domain.usecases.category

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.repositories.db.tables.CategoryDAO

object CreateCategoryUseCase {

    fun execute(category: CategoryImpl): Boolean {
        return CategoryDAO.insert(model = category) > 0
    }

}