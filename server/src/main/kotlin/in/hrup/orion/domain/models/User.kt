package `in`.hrup.orion.domain.models

interface User{
    val id: Long
    val username: String
    val password: String
    val token: String
}