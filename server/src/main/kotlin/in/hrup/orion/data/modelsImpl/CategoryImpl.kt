package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Category
import kotlinx.serialization.Serializable

@Serializable
data class CategoryImpl(
    override val id: Long,
    override val name: String,
    override val alias: String,
    override val seoTitle: String,
    override val seoDescription: String,
    override val seoKeywords: String,
    override val seoCanonicalUrl: String
): Category
