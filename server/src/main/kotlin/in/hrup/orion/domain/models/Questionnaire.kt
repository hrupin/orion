package `in`.hrup.orion.domain.models

interface Questionnaire {
    val id: Long
    val name: String
    val lastName: String
    val birthday: Long
    val phone: String
    val email: String
    val militaryBranch: String
    val comment: String
    val status: Int
}