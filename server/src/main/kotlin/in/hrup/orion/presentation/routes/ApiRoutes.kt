package `in`.hrup.orion.presentation.routes

import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.domain.dto.VideosDTO
import `in`.hrup.orion.domain.usecases.posts.FetchPagedPostsUseCase
import `in`.hrup.orion.domain.usecases.videos.FetchPagedVideosUseCase
import `in`.hrup.orion.presentation.queries.PostsQueryParams
import `in`.hrup.orion.presentation.queries.VideosQueryParams
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

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
                tag = params.tag
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

    }

}