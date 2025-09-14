package `in`.hrup.orion.data.modelsImpl

import `in`.hrup.orion.domain.models.Questionnaire
import kotlinx.serialization.Serializable

@Serializable
data class QuestionnaireImpl(
    override val id: Long,
    override val name: String,
    override val lastName: String,
    override val birthday: Long,
    override val phone: String,
    override val email: String,
    override val militaryBranch: String,
    override val comment: String,
    override val status: Int = 0
): Questionnaire
