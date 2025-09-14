package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import `in`.hrup.orion.domain.models.CustomData
import `in`.hrup.orion.presentation.ui.components.field
import `in`.hrup.orion.presentation.ui.components.textareaField
import kotlinx.html.ButtonType
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.b
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h3
import kotlinx.html.h5
import kotlinx.html.h6
import kotlinx.html.hr
import kotlinx.html.input
import kotlinx.html.p
import kotlin.collections.forEach

fun SECTION.faqScreen(faqs: List<FaqImpl>, url: String = "", faq: FaqImpl? = null) {

    form(classes = "box", action = "/admin/faq", method = FormMethod.post, encType = FormEncType.multipartFormData) {
        input(type = InputType.hidden, name = "id") {
            value = faq?.id?.toString() ?: "0"
        }
        field("Питання", "question", faq?.question)
        textareaField("Відповідь", "", "answer", faq?.answer, rows = 3)
        field("Сортування", "sort", faq?.sort.toString())

        br{}

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }
    }

    faqs.forEach {
        div(classes = "box") {
            h3{
                b{
                    +it.question
                }
            }
            p{
                +it.answer
            }
            hr{}
            div(classes = "buttons"){
                a(classes = "button is-warning"){
                    href = "${url}?action=edit&id=${it.id}"
                    +"Edit"
                }
                a(classes = "button is-danger"){
                    href = "${url}?action=remove&id=${it.id}"
                    +"Remove"
                }
            }
        }
    }

    hr{}

}