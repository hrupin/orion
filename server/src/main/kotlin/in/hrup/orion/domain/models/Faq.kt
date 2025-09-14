package `in`.hrup.orion.domain.models

interface Faq {
    val id: Long
    val question: String
    val answer: String
    val sort: Int
}