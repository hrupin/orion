package `in`.hrup.orion.domain.usecases.questionnaire

import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO
import `in`.hrup.orion.data.repositories.db.tables.QuestionnaireDAO
import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.domain.dto.QuestionnaireDTO
import `in`.hrup.orion.domain.models.Questionnaire

object GetQuestionnairesDtoUseCase{

    fun execute(limit: Int = 20, offset: Int): QuestionnaireDTO{
        val questionnaire: List<QuestionnaireImpl> = QuestionnaireDAO.fetchPaged(
            limit = limit,
            offset = offset
        )
        val questionnaireCount = QuestionnaireDAO.count()
        val currentPage = if (limit > 0) {
            (offset / limit) + 1
        } else 1
        val totalPages = if (limit > 0) {
            ((questionnaireCount + limit - 1) /limit).toInt()
        } else 1
        return QuestionnaireDTO(
            list = questionnaire,
            count = questionnaireCount,
            currentPage = currentPage,
            totalPages = totalPages,
        )
    }

}