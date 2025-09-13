package `in`.hrup.orion.domain.usecases.category

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.repositories.db.tables.CategoryDAO

object GetCategoriesUseCase {

    fun execute(): List<CategoryImpl> {
        return CategoryDAO.fetchAll()
    }

}