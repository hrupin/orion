package `in`.hrup.orion.domain.models

interface Category {
    val id: Long
    val name: String
    val alias: String
    val seoTitle: String
    val seoDescription: String
    val seoKeywords: String
    val seoCanonicalUrl: String
}