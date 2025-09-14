package `in`.hrup.orion.domain.usecases.faq

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import `in`.hrup.orion.data.repositories.db.tables.FaqDAO

object GetFaqByIdUseCase {

    fun execute(id: Long): FaqImpl? {
        return FaqDAO.fetchById(id = id)
    }

}