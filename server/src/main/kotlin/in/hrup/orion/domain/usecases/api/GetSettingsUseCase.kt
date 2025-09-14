package `in`.hrup.orion.domain.usecases.api

import `in`.hrup.orion.data.repositories.db.tables.CustomDataDAO
import `in`.hrup.orion.domain.models.CustomData

object GetSettingsUseCase {

    fun execute(): List<CustomData>{
        return CustomDataDAO.fetchAll()
    }

}