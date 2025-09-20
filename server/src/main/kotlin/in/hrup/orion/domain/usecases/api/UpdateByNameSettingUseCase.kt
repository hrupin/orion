package `in`.hrup.orion.domain.usecases.api

import `in`.hrup.orion.data.modelsImpl.CustomDataImpl
import `in`.hrup.orion.data.repositories.db.tables.CustomDataDAO

object UpdateByNameSettingUseCase {

    fun execute(model: CustomDataImpl): Boolean{
        return CustomDataDAO.updateByName(model = model)
    }

}