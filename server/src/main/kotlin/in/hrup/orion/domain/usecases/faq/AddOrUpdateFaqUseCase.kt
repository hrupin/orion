package `in`.hrup.orion.domain.usecases.faq

import `in`.hrup.orion.data.modelsImpl.FaqImpl

object AddOrUpdateFaqUseCase {

    fun execute(model: FaqImpl): Boolean {
        return if(model.id > 0){
            UpdateFaqUseCase.execute(model = model)
        }
        else{
            CreateFaqUseCase.execute(model = model) > 0
        }
    }

}