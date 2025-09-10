package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Post

data class PostImpl(
    override val id: Long,
    override val title: String,
    override val slug: String,
    override val content: String,
    override val description: String,
    override val tags: String,
    override val seoTitle: String,
    override val image: String,
    override val category: String,
    override val seoDescription: String,
    override val seoKeywords: String,
    override val seoCanonicalUrl: String,
    override val published: Boolean,
    override val publishedAt: Long = 0,
    override val updatedAt: Long = 0,
    override val createdAt: Long = 0
): Post
