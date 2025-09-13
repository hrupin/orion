package `in`.hrup.orion.domain.usecases.category

import `in`.hrup.orion.data.repositories.db.tables.CategoryDAO

object RemoveCategoryByIdUseCase {

    fun execute(id: Long): Boolean {
        return CategoryDAO.remove(id = id)
    }

}