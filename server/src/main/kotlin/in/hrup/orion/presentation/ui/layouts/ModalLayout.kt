package `in`.hrup.orion.presentation.ui.layouts

import kotlinx.html.ButtonType
import kotlinx.html.p
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.header
import kotlinx.html.button
import kotlinx.html.section
import kotlinx.html.SECTION
import kotlinx.html.id

fun SECTION.modalLayout(idModal: String = "", idForm: String = "", content: SECTION.() -> Unit) {
    div(classes = "modal") {
        id = idModal
        div(classes = "modal-background") {}
        div(classes = "modal-card") {
            header(classes = "modal-card-head") {
                p(classes = "modal-card-title") {
                    +"Вікно завантаження дампа сайту"
                }
                button(classes = "delete") {
                    attributes["aria-label"] = "close"
                }
            }
            section(classes = "modal-card-body") {
                content()
            }
            footer(classes = "modal-card-foot") {
                div(classes = "buttons") {
                    button(classes = "button is-success", type = ButtonType.submit) {
                        attributes["form"] = idForm
                        +"Зберегти"
                    }
                    button(classes = "button") { +"Скасувати" }
                }
            }
        }
    }
}