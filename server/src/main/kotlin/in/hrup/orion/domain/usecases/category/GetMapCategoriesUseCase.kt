package `in`.hrup.orion.domain.usecases.category

object GetMapCategoriesUseCase {

    fun execute(): Map<String, String>{
        val categories = GetCategoriesUseCase.execute()
        return categories.associate { category ->
            category.alias to category.name
        }
    }

}