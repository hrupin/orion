package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.User

data class UserImpl(
    override val id: Long,
    override val username: String,
    override val password: String,
    override val token: String
): User