package `in`.hrup.orion.domain.usecases.questionnaire

import `in`.hrup.orion.data.repositories.db.tables.QuestionnaireDAO

object SetStatusQuestionnaireUseCase {

    fun execute(id: Long, status: Int): Boolean{
        return QuestionnaireDAO.setStatus(id = id, st = status)
    }

}