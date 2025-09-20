package `in`.hrup.orion.presentation.routes

import `in`.hrup.orion.data.modelsImpl.CustomDataImpl
import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.domain.dto.VideosDTO
import `in`.hrup.orion.domain.usecases.api.GetFaqsUseCase
import `in`.hrup.orion.domain.usecases.api.GetSettingsUseCase
import `in`.hrup.orion.domain.usecases.category.GetCategoriesUseCase
import `in`.hrup.orion.domain.usecases.category.GetRandomTagsUseCase
import `in`.hrup.orion.domain.usecases.posts.FetchPagedPostsUseCase
import `in`.hrup.orion.domain.usecases.questionnaire.CreateQuestionnaireUseCase
import `in`.hrup.orion.domain.usecases.videos.FetchPagedVideosUseCase
import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.presentation.queries.PostsQueryParams
import `in`.hrup.orion.presentation.queries.VideosQueryParams
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.io.File

fun Application.apiRoutes() {

    routing {

        get("api/posts"){
            val qp = call.request.queryParameters
            val params = PostsQueryParams(
                page = qp["page"]?.toIntOrNull() ?: 1,
                month = qp["month"]?.toIntOrNull(),
                year = qp["year"]?.toIntOrNull(),
                tag = qp["tag"]
            )
            val limit = 20
            val offset = 0
            val result = FetchPagedPostsUseCase.execute(
                limit = limit,
                offset = offset,
                month = params.month,
                year = params.year,
                category = null,
                tag = params.tag
            )
            call.respond(result)
        }

        get("api/category/{category}") {
            val qp = call.request.queryParameters
            val category = call.parameters["category"]
            val params = PostsQueryParams(
                page = qp["page"]?.toIntOrNull() ?: 1,
                month = qp["month"]?.toIntOrNull(),
                year = qp["year"]?.toIntOrNull(),
                tag = qp["tag"]
            )
            val limit = 20
            val offset = 0
            val result = FetchPagedPostsUseCase.execute(
                limit = limit,
                offset = offset,
                month = params.month,
                year = params.year,
                category = category,
                tag = params.tag
            )
            call.respond(result)
        }

        get("api/tag/{tag}") {
            val qp = call.request.queryParameters
            val t: String? = call.parameters["tag"]
            val params = PostsQueryParams(
                page = qp["page"]?.toIntOrNull() ?: 1,
                month = qp["month"]?.toIntOrNull(),
                year = qp["year"]?.toIntOrNull(),
                tag = qp["tag"]
            )
            val limit = 20
            val offset = 0
            val result = FetchPagedPostsUseCase.execute(
                limit = limit,
                offset = offset,
                month = params.month,
                year = params.year,
                category = null,
                tag = t
            )
            call.respond(result)
        }

        get("api/videos"){
            val qp = call.request.queryParameters
            val params = VideosQueryParams(
                page = qp["page"]?.toIntOrNull() ?: 1,
                month = qp["month"]?.toIntOrNull(),
                year = qp["year"]?.toIntOrNull(),
                tag = qp["tag"]
            )
            val limit = 20
            val offset = 0
            val result = FetchPagedVideosUseCase.execute(
                limit = limit,
                offset = offset,
                month = params.month,
                year = params.year,
                tag = params.tag
            )
            call.respond(result)
        }

        get("api/settings"){
            val result = GetSettingsUseCase.execute()
            val dtoList = result.map {
                CustomDataImpl(it.id, it.name, it.value)
            }
            call.respond(dtoList)
        }

        get("api/categories"){
            val result = GetCategoriesUseCase.execute()
            call.respond(result)
        }

        get("api/tags"){
            val result = GetRandomTagsUseCase.execute()
            call.respond(result)
        }

        get("api/faq"){
            val result = GetFaqsUseCase.execute()
            call.respond(result)
        }

        post("/api/questionnaire"){
            val formData = call.receive<QuestionnaireImpl>()
            if(CreateQuestionnaireUseCase.execute(questionnaire = formData)){
                call.respond(HttpStatusCode.OK)
            }
            else{
                call.respond(HttpStatusCode.BadRequest)
            }
        }

        get("api/image/{image}"){
            val fileName = call.parameters["image"] ?: ""

            val imageFile = File("${FileUtil.getDirMain()}/posts", fileName)

            println("IMAGE ==>> ${imageFile.absolutePath}")

            if (!imageFile.exists() || !imageFile.isFile) {
                call.respond(HttpStatusCode.NotFound, "Image file not found on disk.")
                return@get
            }

            call.respondFile(imageFile)
        }

    }

}