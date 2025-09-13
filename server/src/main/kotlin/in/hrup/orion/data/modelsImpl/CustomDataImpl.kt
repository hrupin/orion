package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.CustomData

data class CustomDataImpl(
    override val id: Long,
    override val name: String,
    override val value: String
): CustomData