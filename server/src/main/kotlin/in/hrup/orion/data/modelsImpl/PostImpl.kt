package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostImpl(
    val id: Long,
    val title: String,
    val slug: String,
    val content: String,
    val description: String,
    val tags: String,
    val seoTitle: String,
    val image: String,
    val category: String,
    val seoDescription: String,
    val seoKeywords: String,
    val seoCanonicalUrl: String,
    val published: Boolean,
    val publishedAt: Long = 0,
    val updatedAt: Long = 0,
    val createdAt: Long = 0
)//: Post
