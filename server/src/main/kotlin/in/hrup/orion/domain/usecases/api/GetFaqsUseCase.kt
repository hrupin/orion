package `in`.hrup.orion.domain.usecases.api

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import `in`.hrup.orion.data.repositories.db.tables.FaqDAO

object GetFaqsUseCase {

    fun execute(): List<FaqImpl>{
        return FaqDAO.fetchAll()
    }

}