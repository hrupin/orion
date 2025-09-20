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
import kotlinx.html.*

fun SECTION.settingsScreen(settings: List<CustomData>) {

    val socials = settings.filter { it.id < 8 }
    val contacts = settings.filter { it.id >= 8 }

    form(classes = "box", action = "/admin/settings", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        div(classes = "box"){
            h2(classes = "title") {
                +"Social media block"
            }
            socials.forEach {
                field(it.name, it.name, it.value)
            }
        }

        div(classes = "box"){
            h2(classes = "title") {
                +"Contacts block"
            }
            contacts.forEach {
                field(it.name, it.name, it.value)
            }
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