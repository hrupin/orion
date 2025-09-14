package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Faq
import kotlinx.serialization.Serializable

@Serializable
data class FaqImpl(
    override val id: Long,
    override val question: String,
    override val answer: String,
    override val sort: Int
): Faq
