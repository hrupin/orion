package `in`.hrup.orion.presentation.controllers

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.domain.utils.StringUtil
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveMultipart
import io.ktor.utils.io.cancel
import io.ktor.utils.io.jvm.javaio.copyTo
import java.io.File

class PostsController {

    suspend fun create(call: ApplicationCall): PostImpl {
        var title = ""
        var slug = ""
        var content = ""
        var description = ""
        var tags = ""
        var seoTitle = ""
        var seoDescription = ""
        var seoKeywords = ""
        var seoCanonicalUrl = ""
        var published = false
        var fileName: String? = null
        val uploadDir = File("uploads")
        if (!uploadDir.exists()) uploadDir.mkdirs()
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when (part.name) {
                        "title" -> {
                            title = part.value
                            seoCanonicalUrl = "/posts/" + StringUtil.toSlug(part.value)
                            slug = StringUtil.toSlug(part.value)
                        }
                        "content" -> content = part.value
                        "description" -> description = part.value
                        "tags" -> tags = part.value
                        "seoTitle" -> seoTitle = part.value
                        "seoDescription" -> seoDescription = part.value
                        "seoKeywords" -> seoKeywords = part.value
                        "published" -> published = part.value.toBooleanStrictOrNull() ?: false
                    }
                }
                is PartData.FileItem -> {
                    val originalName = part.originalFileName ?: "unnamed"

                    println("FILE NAME: $originalName")

                    val ext = File(originalName).extension.lowercase()
                    val allowed = listOf("jpg", "jpeg", "png", "mp4", "webm")
                    if (ext in allowed) {
                        fileName = "upload_${System.currentTimeMillis()}.$ext"
                        val file = File(uploadDir, fileName!!)
                        val inputStream = part.provider()
                        file.outputStream().use { output ->
                            inputStream.copyTo(output)
                            inputStream.cancel()
                        }
                    }
                }
                else -> {}
            }
            part.dispose()
        }
        return PostImpl(
            id = 0,
            title = title,
            slug = slug,
            content = content,
            description = description,
            tags = tags,
            seoTitle = seoTitle,
            seoDescription = seoDescription,
            seoKeywords = seoKeywords,
            seoCanonicalUrl = seoCanonicalUrl,
            published = published
        )
    }

}