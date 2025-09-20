package `in`.hrup.orion.presentation.controllers

import `in`.hrup.orion.domain.usecases.api.UpdateByNameSettingUseCase
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.html.Entities
import `in`.hrup.orion.data.modelsImpl.CustomDataImpl

class SettingsController {

    suspend fun save(call: ApplicationCall): Boolean{
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            if (part is PartData.FormItem) {
                println("${part.name} / ${part.value}")
                UpdateByNameSettingUseCase.execute(
                    model = CustomDataImpl(
                        id = 0,
                        name = part.name.toString(),
                        value = part.value.toString()
                    )
                )
            }

        }
        return true
    }

}