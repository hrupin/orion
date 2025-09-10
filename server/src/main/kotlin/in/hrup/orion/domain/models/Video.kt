package `in`.hrup.orion.domain.models

interface Video {
    val id: Long
    val title: String
    val slug: String
    val description: String
    val video: String
    val tags: String
    val seoTitle: String
    val seoDescription: String
    val seoKeywords: String
    val seoCanonicalUrl: String
    val published: Boolean
    val publishedAt: Long
    val updatedAt: Long
    val createdAt: Long
}