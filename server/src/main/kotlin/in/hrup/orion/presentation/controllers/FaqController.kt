package `in`.hrup.orion.presentation.controllers

import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import `in`.hrup.orion.data.modelsImpl.FaqImpl
import io.ktor.server.request.receiveMultipart
import io.ktor.server.application.ApplicationCall

class FaqController {

    suspend fun create(call: ApplicationCall): FaqImpl {
        var id: Long? = 0
        var question = ""
        var answer = ""
        var sort = ""

        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when (part.name) {
                        "id" -> id = part.value.toLongOrNull()
                        "question" -> question = part.value
                        "answer" -> answer = part.value
                        "sort" -> sort = part.value
                    }
                }
                else -> {}
            }
        }
        return FaqImpl(
            id = id ?: 0,
            question = question,
            answer = answer,
            sort = sort.toInt()
        )
    }

}