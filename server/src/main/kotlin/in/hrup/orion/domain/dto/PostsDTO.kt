package `in`.hrup.orion.domain.dto

import `in`.hrup.orion.domain.models.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostsDTO(
    val posts: List<Post>,
    val count: Long,
    val currentPage: Int,
    val totalPages: Int
)