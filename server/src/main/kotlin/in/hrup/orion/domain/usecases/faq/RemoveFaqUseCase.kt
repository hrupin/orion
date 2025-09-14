package `in`.hrup.orion.domain.usecases.faq

import `in`.hrup.orion.data.repositories.db.tables.FaqDAO

object RemoveFaqUseCase {

    fun execute(id: Long): Boolean {
        return FaqDAO.remove(id) != null
    }

}