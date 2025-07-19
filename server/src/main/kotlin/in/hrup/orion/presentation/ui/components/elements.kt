package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.FlowContent
import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.p
import kotlinx.html.textArea

fun FlowContent.field(labelText: String, name: String, value: String? = null) {
    div("field is-horizontal") {
        div(classes = "field-label is-normal"){
            label("label mar0") { +labelText }
        }
        div(classes = "field-body") {
            div(classes = "field") {
                p("control") {
                    input(classes = "input", type = InputType.text, name = name) {
                        value?.let { this.value = it }
                    }
                }
            }
        }
    }
}

fun FlowContent.textareaField(labelText: String, name: String, value: String? = null, rows: Int? = 3) {
    div("field") {
        textArea(classes = "textarea"){
            attributes["placeholder"] = labelText
            attributes["rows"] = rows.toString()
        }
    }
}

fun FlowContent.staticField(labelText: String, value: String) {
    div("field") {
        label("label") { +labelText }
        div("control") {
            p("input is-static") {
                +value
            }
        }
    }
}