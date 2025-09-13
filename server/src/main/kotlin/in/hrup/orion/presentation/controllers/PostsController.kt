package `in`.hrup.orion.presentation.controllers

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.domain.utils.StringUtil
import `in`.hrup.orion.presentation.models.Uploader
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveMultipart
import io.ktor.utils.io.cancel
import io.ktor.utils.io.jvm.javaio.copyTo
import java.io.File

class PostsController {

    suspend fun create(call: ApplicationCall): PostImpl {
        var id: Long? = 0
        var title = ""
        var slug = ""
        var content = ""
        var description = ""
        var category = ""
//        var tags = ""
        val tags = mutableListOf<String>()
        var seoTitle = ""
        var seoDescription = ""
        var seoKeywords = ""
        var seoCanonicalUrl = ""
        var published = false
        var fileName: String = ""
        var oldFileName: String = ""
        val uploadDir = File("uploads")
        if (!uploadDir.exists()) uploadDir.mkdirs()
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when (part.name) {
                        "id" -> id = part.value.toLongOrNull()
                        "title" -> {
                            title = part.value
                            seoCanonicalUrl = "/posts/" + StringUtil.toSlug(part.value)
                            slug = StringUtil.toSlug(part.value)
                        }
                        "category" -> category = part.value
                        "oldFileName" -> oldFileName = part.value
                        "content" -> content = part.value
                        "description" -> description = part.value
                        "tags[]" -> tags.add(part.value)
                        "seoTitle" -> seoTitle = part.value
                        "seoDescription" -> seoDescription = part.value
                        "seoKeywords" -> seoKeywords = part.value
                        "published" -> published = part.value.toBooleanStrictOrNull() ?: false
                    }
                }
                is PartData.FileItem -> {
                    fileName = Uploader.file(
                        part = part,
                        dir = "posts",
                        allowedExt = listOf("jpg", "jpeg", "png")
                    )
                }
                else -> {
                    fileName = oldFileName
                }
            }
        }

        return PostImpl(
            id = id ?: 0,
            title = title,
            slug = slug,
            content = content,
            description = description,
            image = fileName,
            category = category,
            tags = tags.joinToString(","),
            seoTitle = seoTitle,
            seoDescription = seoDescription,
            seoKeywords = seoKeywords,
            seoCanonicalUrl = seoCanonicalUrl,
            published = published
        )
    }

}