package `in`.hrup.orion.domain.usecases.faq

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import `in`.hrup.orion.data.repositories.db.tables.FaqDAO

object UpdateFaqUseCase {

    fun execute(model: FaqImpl): Boolean {
        return FaqDAO.update(model = model)
    }

}