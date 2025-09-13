package `in`.hrup.orion.presentation.controllers

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import `in`.hrup.orion.domain.utils.StringUtil
import `in`.hrup.orion.presentation.models.Uploader
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveMultipart
import java.io.File

class VideosController {

    suspend fun create(call: ApplicationCall): VideoImpl {
        var title = ""
        var slug = ""
        var description = ""
        var tags = ""
        var seoTitle = ""
        var seoDescription = ""
        var seoKeywords = ""
        var seoCanonicalUrl = ""
        var published = false
        var fileName: String = ""
        val uploadDir = File("uploads")
        if (!uploadDir.exists()) uploadDir.mkdirs()
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when (part.name) {
                        "title" -> {
                            title = part.value
                            val slugTmp = StringUtil.toSlug(part.value)
                            seoCanonicalUrl = "/video/" + slugTmp
                            slug = slugTmp
                        }
                        "description" -> description = part.value
                        "tags" -> tags = part.value
                        "seoTitle" -> seoTitle = part.value
                        "seoDescription" -> seoDescription = part.value
                        "seoKeywords" -> seoKeywords = part.value
                        "published" -> published = part.value.toBooleanStrictOrNull() ?: false
                    }
                }
                is PartData.FileItem -> {
                    fileName = Uploader.file(
                        part = part,
                        dir = "video",
                        allowedExt = listOf("mp4", "webm", "mov", "mkv")
                    )
                }
                else -> {}
            }
        }
        return VideoImpl(
            id = 0,
            title = title,
            slug = slug,
            description = description,
            video = fileName,
            tags = "",
            seoTitle = seoTitle,
            seoDescription = seoDescription,
            seoKeywords = seoKeywords,
            seoCanonicalUrl = seoCanonicalUrl,
            published = published
        )
    }

}