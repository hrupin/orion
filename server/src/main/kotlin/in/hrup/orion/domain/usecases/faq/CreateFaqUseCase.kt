package `in`.hrup.orion.domain.usecases.faq

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import `in`.hrup.orion.data.repositories.db.tables.FaqDAO

object CreateFaqUseCase {

    fun execute(model: FaqImpl): Long {
        return FaqDAO.insert(model = model)
    }

}