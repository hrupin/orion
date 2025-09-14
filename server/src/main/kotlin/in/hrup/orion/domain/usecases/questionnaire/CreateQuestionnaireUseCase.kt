package `in`.hrup.orion.domain.usecases.questionnaire

import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import `in`.hrup.orion.data.repositories.db.tables.QuestionnaireDAO

object CreateQuestionnaireUseCase {

    fun execute(questionnaire: QuestionnaireImpl): Boolean {
        return QuestionnaireDAO.insert(model = questionnaire) > 0
    }

}