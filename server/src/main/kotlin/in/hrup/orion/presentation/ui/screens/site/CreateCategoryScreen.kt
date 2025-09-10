package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.presentation.ui.components.formCreateCategory
import `in`.hrup.orion.presentation.ui.components.formCreatePost
import kotlinx.html.SECTION

fun SECTION.createCategoryScreen(category: CategoryImpl? = null) {
    formCreateCategory(category = category)
}