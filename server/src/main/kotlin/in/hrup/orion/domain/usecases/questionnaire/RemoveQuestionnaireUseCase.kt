package `in`.hrup.orion.domain.usecases.questionnaire

import `in`.hrup.orion.data.repositories.db.tables.QuestionnaireDAO

object RemoveQuestionnaireUseCase {

    fun execute(id: Long): Boolean {
        return QuestionnaireDAO.remove(id = id)
    }

}