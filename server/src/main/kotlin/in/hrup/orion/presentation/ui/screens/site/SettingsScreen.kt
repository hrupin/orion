package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.domain.models.CustomData
import `in`.hrup.orion.domain.usecases.category.GetMapCategoriesUseCase
import `in`.hrup.orion.domain.usecases.posts.GetTagsUseCase
import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.presentation.ui.components.field
import `in`.hrup.orion.presentation.ui.components.fieldTags
import `in`.hrup.orion.presentation.ui.components.fileField
import `in`.hrup.orion.presentation.ui.components.renderTree
import `in`.hrup.orion.presentation.ui.components.selectField
import `in`.hrup.orion.presentation.ui.components.textareaField
import kotlinx.html.ButtonType
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.SECTION
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form

fun SECTION.settingsScreen(settings: List<CustomData>) {

    form(classes = "box", action = "/admin/settings", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        settings.forEach {
            field(it.name, it.name, it.value)
        }

        br{}

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

    }
}