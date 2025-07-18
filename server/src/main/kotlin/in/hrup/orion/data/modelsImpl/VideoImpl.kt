package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Video

data class VideoImpl(
    override val id: Long,
    override val title: String,
    override val slug: String,
    override val description: String,
    override val tags: String,
    override val seoTitle: String,
    override val seoDescription: String,
    override val seoKeywords: String,
    override val seoCanonicalUrl: String,
    override val published: Boolean,
    override val publishedAt: Long,
    override val updatedAt: Long,
    override val createdAt: Long
): Video
