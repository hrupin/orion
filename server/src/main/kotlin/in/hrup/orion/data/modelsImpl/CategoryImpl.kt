package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Category

data class CategoryImpl(
    override val id: Long,
    override val name: String,
    override val alias: String
): Category
