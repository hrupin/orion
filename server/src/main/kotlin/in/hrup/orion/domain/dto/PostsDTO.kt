package `in`.hrup.orion.domain.dto

import kotlinx.serialization.Serializable
import `in`.hrup.orion.data.modelsImpl.PostImpl

@Serializable
data class PostsDTO(
    val posts: List<PostImpl>,
    val count: Long,
    val currentPage: Int,
    val totalPages: Int
)