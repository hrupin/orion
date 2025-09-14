package `in`.hrup.orion.domain.dto

import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import `in`.hrup.orion.domain.models.Post

data class QuestionnaireDTO(
    val list: List<QuestionnaireImpl>,
    val count: Long,
    val currentPage: Int,
    val totalPages: Int
)
