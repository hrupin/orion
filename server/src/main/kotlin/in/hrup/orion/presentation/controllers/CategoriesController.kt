package `in`.hrup.orion.presentation.controllers

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.domain.utils.StringUtil
import `in`.hrup.orion.presentation.models.Uploader
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveMultipart
import java.io.File

class CategoriesController {


    suspend fun create(call: ApplicationCall): CategoryImpl {
        var id: Long? = 0
        var name = ""
        var alias = ""
        var seoTitle = ""
        var seoDescription = ""
        var seoKeywords = ""

        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when (part.name) {
                        "id" -> id = part.value.toLongOrNull()
                        "name" -> name = part.value
                        "alias" -> alias = part.value
                        "seoTitle" -> seoTitle = part.value
                        "seoDescription" -> seoDescription = part.value
                        "seoKeywords" -> seoKeywords = part.value
                    }
                }
                else -> {}
            }
        }
        return CategoryImpl(
            id = id ?: 0,
            name = name,
            alias = alias,
            seoTitle = seoTitle,
            seoDescription = seoDescription,
            seoKeywords = seoKeywords,
            seoCanonicalUrl = "category/${alias}"
        )
    }
}